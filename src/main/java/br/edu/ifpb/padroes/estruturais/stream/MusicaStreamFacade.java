
package br.edu.ifpb.padroes.estruturais.stream;

import java.io.IOException;
import java.util.List;

public class MusicaStreamFacade {
    private final ServicoMusica servico;
    private Reprodutor reprodutor;

    public MusicaStreamFacade(ServicoMusica servico, Reprodutor reprodutor) {
        this.servico = servico;
        this.reprodutor = reprodutor;
    }

    public List<Musica> todas() throws IOException, InterruptedException {
        return servico.buscarTodas();
    }

    public List<Musica> buscarPorTitulo(String termo) throws IOException, InterruptedException {
        return servico.buscarPorTitulo(termo);
    }

    public List<Musica> buscarPorArtista(String artista) throws IOException, InterruptedException {
        return servico.buscarPorArtista(artista);
    }

    public List<Musica> buscarPorGenero(String genero) throws IOException, InterruptedException {
        return servico.buscarPorGenero(genero);
    }

    public void tocar(Musica m) {
        reprodutor.tocar(m);
    }

    public void setReprodutor(Reprodutor novo) {
        this.reprodutor = novo;
    }
}
