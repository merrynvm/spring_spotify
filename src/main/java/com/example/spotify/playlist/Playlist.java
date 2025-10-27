package com.example.spotify.playlist;

import com.example.spotify.song.Song;
import com.example.spotify.user.Suser;
import jakarta.persistence.*;

import java.sql.Time;
import java.util.List;

@Entity
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String owner;
    private Time duration;

    //relazione con Song
    @ManyToMany(mappedBy = "playlists")
    private List<Song> songs;

    @ManyToMany
    @JoinTable(name = "suser_playlists", joinColumns = @JoinColumn(name = "playlist_id"), inverseJoinColumns = @JoinColumn(name = "suser_id"))
    private List<Suser> susers;

    private Playlist(){}

    public Playlist(String name, String owner, Time duration){
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

    public Time getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = Time.valueOf(duration);
    }

}
