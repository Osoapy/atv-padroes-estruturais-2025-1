
package br.edu.ifpb.padroes.estruturais.stream;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServicoMusicaProxy implements ServicoMusica {
    private final ServicoMusica real;
    private final Map<String, List<Musica>> cache = new HashMap<>();

    public ServicoMusicaProxy(ServicoMusica real) {
        this.real = real;
    }

    private List<Musica> memo(String key, Fetcher f) throws IOException, InterruptedException {
        if (cache.containsKey(key)) return cache.get(key);
        var data = f.get();
        cache.put(key, data);
        return data;
    }

    @FunctionalInterface
    interface Fetcher { List<Musica> get() throws IOException, InterruptedException; }

    @Override
    public List<Musica> buscarTodas() throws IOException, InterruptedException {
        return memo("todas", () -> real.buscarTodas());
    }

    @Override
    public List<Musica> buscarPorTitulo(String termo) throws IOException, InterruptedException {
        return memo("titulo:" + termo.toLowerCase(), () -> real.buscarPorTitulo(termo));
    }

    @Override
    public List<Musica> buscarPorArtista(String artista) throws IOException, InterruptedException {
        return memo("artista:" + artista.toLowerCase(), () -> real.buscarPorArtista(artista));
    }

    @Override
    public List<Musica> buscarPorGenero(String genero) throws IOException, InterruptedException {
        return memo("genero:" + genero.toLowerCase(), () -> real.buscarPorGenero(genero));
    }
}
