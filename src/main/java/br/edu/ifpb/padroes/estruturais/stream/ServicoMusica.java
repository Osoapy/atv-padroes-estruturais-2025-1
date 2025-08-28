
package br.edu.ifpb.padroes.estruturais.stream;

import java.io.IOException;
import java.util.List;

public interface ServicoMusica {
    List<Musica> buscarTodas() throws IOException, InterruptedException;
    List<Musica> buscarPorTitulo(String termo) throws IOException, InterruptedException;
    List<Musica> buscarPorArtista(String artista) throws IOException, InterruptedException;
    List<Musica> buscarPorGenero(String genero) throws IOException, InterruptedException;
}
