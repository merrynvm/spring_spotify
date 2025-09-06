package com.example.spotify.song;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepo extends JpaRepository<Song, Long> {}
