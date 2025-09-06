package com.example.spotify.playlist;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepo extends JpaRepository<Playlist, Long> {}
