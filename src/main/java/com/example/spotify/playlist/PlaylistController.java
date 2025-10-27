package com.example.spotify.playlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/playlist")
public class PlaylistController {
    @Autowired PlaylistService playlistService;

    @GetMapping("/all")
    public List<Playlist> playlistAll(){
        return playlistService.playlists();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> playlistById(@PathVariable Long id){
        Optional<Playlist> playlistFound = playlistService.playlistById(id);

        if (playlistFound.isPresent()){
            return ResponseEntity.ok(playlistFound.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/create")
    public ResponseEntity<?> playlistCreate(@RequestBody Playlist newPlaylist){
        Optional<Playlist> playlistCreated = playlistService.playlistCreate(newPlaylist);

        if(playlistCreated.isPresent()){
            return ResponseEntity.ok(playlistCreated.get());
        }

        return ResponseEntity.badRequest().body("I dati inseriti sono mancanti o errati");
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> playlistEdit(@PathVariable Long id, @RequestBody Playlist editedPlaylist){
        Optional<Playlist> playlistToEdit = playlistService.playlistEdit(id, editedPlaylist);

        if(playlistToEdit.isPresent()){
            return ResponseEntity.ok(playlistToEdit);
        }

        return  ResponseEntity.badRequest().body("I dati inseriti o l'id sono errati");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> playlistDelete(@PathVariable Long id){
        Optional <Playlist> playlistFound = playlistService.playlistById(id);

        if(playlistFound.isPresent()){
            playlistService.playlistDelById(id);
            return ResponseEntity.ok("Playlist eliminata");
        }

        return ResponseEntity.notFound().build();
    }

}
