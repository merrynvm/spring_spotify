package com.example.spotify.album;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/album")
public class AlbumController {
    @Autowired AlbumService albumService;

    @GetMapping("/all")
    public List<Album> albumList(){
        return albumService.albumList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Album> albumById(@PathVariable Long id){
        Optional<Album> albumFound = albumService.findAlbumById(id);

        return albumFound.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @PostMapping("/create")
    public ResponseEntity<?> createAlbum(@RequestBody Album newAlbum){
        Optional<Album> createdAlbum = albumService.createAlbum(newAlbum);

        if(createdAlbum.isPresent()){
            return ResponseEntity.ok(createdAlbum.get());
        }

        return ResponseEntity.badRequest().body("Valore/i non valido/i");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateAlbum(@PathVariable Long id, @RequestBody Album albumToUpdate){
        if(albumService.findAlbumById(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Optional<Album> updatedAlbum = albumService.updateAlbum(id, albumToUpdate);

        if(updatedAlbum.isPresent()){
            return ResponseEntity.ok(updatedAlbum.get());
        }

        return ResponseEntity.badRequest().body("Valore/i non valido/i");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAlbum(@PathVariable Long id){
        if(albumService.findAlbumById(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }

        albumService.deleteAlbumById(id);

        return ResponseEntity.ok("Album cancellato con successo.");

    }

}
