
package br.edu.ifpb.padroes.estruturais.stream;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Song {
    private String title;
    private String artist;
    private int year;
    private String genre;

    public Song() {}

    public String getTitle() { return title; }
    public String getArtist() { return artist; }
    public int getYear() { return year; }
    public String getGenre() { return genre; }

    public void setTitle(String title) { this.title = title; }
    public void setArtist(String artist) { this.artist = artist; }
    public void setYear(int year) { this.year = year; }
    public void setGenre(String genre) { this.genre = genre; }
}
