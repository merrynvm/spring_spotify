package com.example.spotify.song;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalTime duration;
    private String artist;

    @Enumerated(EnumType.STRING)
    private SongGenre genre;

    //relazione con album

    private Song(){}

    private Song(String name, LocalTime duration, String artist){
        this.name = name;
        this.duration = duration;
        this.artist = artist;
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

}
