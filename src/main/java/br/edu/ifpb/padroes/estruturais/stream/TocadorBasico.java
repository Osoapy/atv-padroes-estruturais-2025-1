
package br.edu.ifpb.padroes.estruturais.stream;

public class TocadorBasico implements Reprodutor {
    @Override
    public void tocar(Musica musica) {
        System.out.println("Tocando: " + musica.getTitulo() + " - " + musica.getArtista());
    }
}
