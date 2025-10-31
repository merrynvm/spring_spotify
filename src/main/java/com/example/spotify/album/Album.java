package com.example.spotify.album;

import com.example.spotify.song.Song;
import com.example.spotify.song.SongGenre;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String artist;
    private LocalDate release_date;
    private Time duration;
    private SongGenre genre;

    //Relazione con Song
    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JsonManagedReference //Proprietà “padre” (lista) = Viene serializzata
    private List<Song> songs = new ArrayList<>();

    private Album(){}

    public Album(String name, String artist, LocalDate release_date, SongGenre genre, List<Song> songs) {
        this.name = name;
        this.artist = artist;
        this.release_date = release_date;
        this.genre = genre;
        this.songs = songs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public LocalDate getRelease_date() {
        return release_date;
    }

    public void setRelease_date(LocalDate release_date) {
        this.release_date = release_date;
    }

    public SongGenre getGenre() {
        return genre;
    }

    public void setGenre(SongGenre genre) {
        this.genre = genre;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = Time.valueOf(duration);

//       Time finalTime = Time.valueOf("0");
//
//      TODO da finire metodo per calcolo automatico della durata dell'album
//
//        for(Song t : songs){
//            if(t.getDuration() != null){
//                finalTime = finalTime.plusSeconds(t.getDuration().getSecond());
//                finalTime = finalTime.valueOf(t.getDuration().toString());
//            }
//        }
    }

}
