package com.example.spotify.album;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {
    @Autowired AlbumRepo albumRepo;

    public List<Album> albumList(){
        return albumRepo.findAll();
    }

    public Optional<Album> findAlbumById(Long id){
        return albumRepo.findById(id);
    }

    public Optional<Album> createAlbum(Album newAlbum){
        if(newAlbum.getName().isEmpty() || newAlbum.getArtist().isEmpty() || newAlbum.getGenre() == null || newAlbum.getRelease_date() == null){
            return Optional.empty();
        }

        return Optional.of(albumRepo.save(newAlbum));
    }

    public Optional<Album> updateAlbum(Long id, Album albumToUpdate){
        Optional<Album> albumFound = albumRepo.findById(id);

        if(albumFound.isEmpty()){
           return Optional.empty();
        }

        if(albumToUpdate.getName().isEmpty() || albumToUpdate.getArtist().isEmpty() || albumToUpdate.getGenre() == null || albumToUpdate.getRelease_date() == null){
            return Optional.empty();
        }

        albumFound.get().setId(id);
        albumFound.get().setArtist(albumToUpdate.getArtist());
        albumFound.get().setDuration(albumToUpdate.getDuration());
        albumFound.get().setGenre(albumToUpdate.getGenre());
        albumFound.get().setRelease_date(albumToUpdate.getRelease_date());
        albumFound.get().setName(albumToUpdate.getName());
        albumFound.get().setSongs(albumToUpdate.getSongs());

        return Optional.of(albumRepo.save(albumFound.get()));
    }

    public void deleteAlbumById(Long id){
        albumRepo.deleteById(id);
    }

}
