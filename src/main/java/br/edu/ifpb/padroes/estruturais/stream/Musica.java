
package br.edu.ifpb.padroes.estruturais.stream;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Musica {
    private String titulo;
    private String artista;
    private int ano;
    private String genero;

    public Musica() {}

    public Musica(String titulo, String artista, int ano, String genero) {
        this.titulo = titulo;
        this.artista = artista;
        this.ano = ano;
        this.genero = genero;
    }

    public String getTitulo() { return titulo; }
    public String getArtista() { return artista; }
    public int getAno() { return ano; }
    public String getGenero() { return genero; }

    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setArtista(String artista) { this.artista = artista; }
    public void setAno(int ano) { this.ano = ano; }
    public void setGenero(String genero) { this.genero = genero; }

    @Override
    public String toString() {
        return "Musica{" +
                "titulo='" + titulo + '\'' +
                ", artista='" + artista + '\'' +
                ", ano=" + ano +
                ", genero='" + genero + '\'' +
                '}';
    }
}
