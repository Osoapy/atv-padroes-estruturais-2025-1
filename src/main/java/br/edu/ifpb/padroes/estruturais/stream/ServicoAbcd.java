
package br.edu.ifpb.padroes.estruturais.stream;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ServicoAbcd implements ServicoMusica {
    private final String baseUrl; // e.g., http://localhost:3000
    private final HttpClient http = HttpClient.newHttpClient();
    private final ObjectMapper mapper = new ObjectMapper();

    public ServicoAbcd(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    private List<Musica> fetch() throws IOException, InterruptedException {
        // json-server with { "musicas": [...] } serves /musicas
        var req = HttpRequest.newBuilder(URI.create(baseUrl + "/musicas"))
                .GET().build();
        var resp = http.send(req, HttpResponse.BodyHandlers.ofString());
        if (resp.statusCode() >= 400) throw new IOException("Erro HTTP ABCD: " + resp.statusCode());
        var json = resp.body();
        // it might return array directly or object; try array first
        try {
            return mapper.readValue(json, new TypeReference<List<Musica>>(){});
        } catch (Exception e) {
            JsonNode root = mapper.readTree(json);
            JsonNode arr = root.get("musicas");
            if (arr == null || !arr.isArray()) return List.of();
            return mapper.convertValue(arr, new TypeReference<List<Musica>>(){});
        }
    }

    @Override
    public List<Musica> buscarTodas() throws IOException, InterruptedException {
        return fetch();
    }

    @Override
    public List<Musica> buscarPorTitulo(String termo) throws IOException, InterruptedException {
        String q = termo.toLowerCase();
        return fetch().stream()
                .filter(m -> m.getTitulo() != null && m.getTitulo().toLowerCase().contains(q))
                .collect(Collectors.toList());
    }

    @Override
    public List<Musica> buscarPorArtista(String artista) throws IOException, InterruptedException {
        String q = artista.toLowerCase();
        return fetch().stream()
                .filter(m -> m.getArtista() != null && m.getArtista().toLowerCase().contains(q))
                .collect(Collectors.toList());
    }

    @Override
    public List<Musica> buscarPorGenero(String genero) throws IOException, InterruptedException {
        String q = genero.toLowerCase();
        return fetch().stream()
                .filter(m -> m.getGenero() != null && m.getGenero().toLowerCase().contains(q))
                .collect(Collectors.toList());
    }
}
