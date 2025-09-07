package com.example.spotify.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SuserRepo extends JpaRepository<Suser, Long> {

    Optional<Suser> findByNickname(String nickname);

}
