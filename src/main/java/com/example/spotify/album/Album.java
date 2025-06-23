package com.example.spotify.album;

import com.example.spotify.song.Song;
import com.example.spotify.song.SongGenre;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String artist;
    private LocalDate release_date;
    private LocalTime duration;
    private SongGenre genre;

    @OneToMany
    private List<Song> songs;

    public Album(Long id, String name, String artist, LocalDate release_date, List<Song> songs) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.release_date = release_date;
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

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public LocalTime getDuration() {
        return duration;
    }

    public void setDuration(LocalTime duration) {
        LocalTime finalTime = LocalTime.of(0,0,0);

        //TODO da finire metodo per calcolo automatico della durata dell'album
        for(Song t : songs){
            if(t.getDuration() != null){
                //finalTime.plus();
            }
        }
    }

    public SongGenre getGenre() {
        return genre;
    }

    public void setGenre(SongGenre genre) {
        for(Song g : songs){
            if(g.getGenre() != null){
                this.genre = g.getGenre();
                break;
            }
        }
    }

}
