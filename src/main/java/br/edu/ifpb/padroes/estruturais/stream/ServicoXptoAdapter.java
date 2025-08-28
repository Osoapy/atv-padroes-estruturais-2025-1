
package br.edu.ifpb.padroes.estruturais.stream;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class ServicoXptoAdapter implements ServicoMusica {
    private final ClientXpto client;

    public ServicoXptoAdapter(ClientXpto client) {
        this.client = client;
    }

    private List<Musica> convert(List<Song> songs) {
        return songs.stream()
                .map(s -> new Musica(s.getTitle(), s.getArtist(), s.getYear(), s.getGenre()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Musica> buscarTodas() throws IOException, InterruptedException {
        return convert(client.fetch());
    }

    @Override
    public List<Musica> buscarPorTitulo(String termo) throws IOException, InterruptedException {
        String q = termo.toLowerCase();
        return convert(client.fetch()).stream()
                .filter(m -> m.getTitulo() != null && m.getTitulo().toLowerCase().contains(q))
                .toList();
    }

    @Override
    public List<Musica> buscarPorArtista(String artista) throws IOException, InterruptedException {
        String q = artista.toLowerCase();
        return convert(client.fetch()).stream()
                .filter(m -> m.getArtista() != null && m.getArtista().toLowerCase().contains(q))
                .toList();
    }

    @Override
    public List<Musica> buscarPorGenero(String genero) throws IOException, InterruptedException {
        String q = genero.toLowerCase();
        return convert(client.fetch()).stream()
                .filter(m -> m.getGenero() != null && m.getGenero().toLowerCase().contains(q))
                .toList();
    }
}
