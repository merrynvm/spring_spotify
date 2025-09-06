package com.example.spotify.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuserRepo extends JpaRepository<Suser, Long> {}
