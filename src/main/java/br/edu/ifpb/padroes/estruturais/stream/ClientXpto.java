
package br.edu.ifpb.padroes.estruturais.stream;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class ClientXpto {
    private final String baseUrl; // e.g., http://localhost:4000
    private final HttpClient http = HttpClient.newHttpClient();
    private final ObjectMapper mapper = new ObjectMapper();

    public ClientXpto(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public List<Song> fetch() throws IOException, InterruptedException {
        var req = HttpRequest.newBuilder(URI.create(baseUrl + "/musics"))
                .GET().build();
        var resp = http.send(req, HttpResponse.BodyHandlers.ofString());
        if (resp.statusCode() >= 400) throw new IOException("Erro HTTP XPTO: " + resp.statusCode());
        var json = resp.body();
        try {
            return mapper.readValue(json, new TypeReference<List<Song>>(){});
        } catch (Exception e) {
            JsonNode root = mapper.readTree(json);
            JsonNode arr = root.get("musics");
            return mapper.convertValue(arr, new TypeReference<List<Song>>(){});
        }
    }
}
