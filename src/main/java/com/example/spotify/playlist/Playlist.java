package com.example.spotify.playlist;

import com.example.spotify.song.Song;
import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.List;

@Entity
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String owner;
    private LocalTime duration;

    @ManyToMany(mappedBy = "playlists")
    private List<Song> songs;

    private Playlist(){}

    public Playlist(Long id, String name, String owner, LocalTime duration){
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.duration = duration;
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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public LocalTime getDuration() {
        return duration;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

}
