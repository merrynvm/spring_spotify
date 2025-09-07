package com.example.spotify.song;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/song")
public class SongController {
    @Autowired private SongService songService;

    @GetMapping("/all")
    public List<Song> allSongs(){
        return songService.allSongs();
    }

    @PostMapping("/create")
    public ResponseEntity<?> createSong(@RequestBody Song newSong){
        Optional<Song> createdSong = songService.createSong(newSong);

        if(createdSong.isPresent()){
            return ResponseEntity.ok(createdSong.get());
        }else {
           return ResponseEntity.badRequest().body("La canzone non rispetta i campi obbligatori oppure l'utente selezionato non è un artista.");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> songById(@PathVariable Long id){
        Optional<Song> foundSong = songService.songById(id);

        if(foundSong.isPresent()){
            return ResponseEntity.ok(foundSong.get());
        } else {
            return ResponseEntity.badRequest().body("L'id non è valido.");
        }
    }

}
