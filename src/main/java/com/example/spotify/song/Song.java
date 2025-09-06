package com.example.spotify.song;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalTime duration;
    private String artist;
    private LocalDate release_date;

    @Enumerated(EnumType.STRING)
    private SongGenre genre;

    //relazione con album

    private Song(){}

    private Song(String name, LocalTime duration, String artist, LocalDate release_date, SongGenre genre){
        this.name = name;
        this.duration = duration;
        this.artist = artist;
        this.release_date = release_date;
        this.genre = genre;
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

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

    public LocalTime getDuration() {
        return duration;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
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

}
