
package br.edu.ifpb.padroes.estruturais.stream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ServicoComposto implements ServicoMusica {
    private final List<ServicoMusica> fontes;

    public ServicoComposto(List<ServicoMusica> fontes) {
        this.fontes = new ArrayList<>(fontes);
    }

    @Override
    public List<Musica> buscarTodas() throws IOException, InterruptedException {
        List<Musica> acc = new ArrayList<>();
        for (var f : fontes) acc.addAll(f.buscarTodas());
        return acc;
    }

    @Override
    public List<Musica> buscarPorTitulo(String termo) throws IOException, InterruptedException {
        List<Musica> acc = new ArrayList<>();
        for (var f : fontes) acc.addAll(f.buscarPorTitulo(termo));
        return acc;
    }

    @Override
    public List<Musica> buscarPorArtista(String artista) throws IOException, InterruptedException {
        List<Musica> acc = new ArrayList<>();
        for (var f : fontes) acc.addAll(f.buscarPorArtista(artista));
        return acc;
    }

    @Override
    public List<Musica> buscarPorGenero(String genero) throws IOException, InterruptedException {
        List<Musica> acc = new ArrayList<>();
        for (var f : fontes) acc.addAll(f.buscarPorGenero(genero));
        return acc;
    }
}
