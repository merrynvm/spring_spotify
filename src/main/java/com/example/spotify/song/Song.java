package com.example.spotify.song;

import com.example.spotify.album.Album;
import com.example.spotify.playlist.Playlist;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Time duration;
    private String artist;
    private LocalDate release_date;

    @Enumerated(EnumType.STRING)
    private SongGenre genre;

    //relazione con album
    @ManyToOne
    @JoinColumn(name = "album_id")
    @JsonBackReference //Proprietà “figlio” (singolo) = Non viene serializzata
    private Album album;

    //relazione con playlist
    @ManyToMany
    @JoinTable(name = "song_playlist", joinColumns = @JoinColumn(name = "song_id"), inverseJoinColumns = @JoinColumn(name = "playlist_id"))
    private List<Playlist> playlists;

    private Song(){}

    public Song(String name, Time duration, String artist, LocalDate release_date, SongGenre genre){
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

    public void setDuration(String duration) {
        this.duration = Time.valueOf(duration);
    }

    public Time getDuration() {
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

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

}
