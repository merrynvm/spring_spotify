package com.example.spotify.playlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;
import java.util.Optional;

@Service
public class PlaylistService {
    @Autowired PlaylistRepo playlistRepo;

    public List<Playlist> playlists(){
        return playlistRepo.findAll();
    }

    public Optional<Playlist> playlistById(Long id){
        return playlistRepo.findById(id);
    }

    public Optional<Playlist> playlistCreate(Playlist newPlaylist){
        if(newPlaylist.getOwner().isEmpty()){
            return Optional.empty();
        }

        if(newPlaylist.getName().isEmpty() ){
            newPlaylist.setName("La mia nuova Playlist");
        }

        if(newPlaylist.getDuration() == null){
            newPlaylist.setDuration("0");
        }

        return Optional.of(playlistRepo.save(newPlaylist));
    }

    public Optional<Playlist> playlistEdit(Long id, Playlist playlistEdited){
        if(playlistById(id).isEmpty() || playlistEdited.getOwner().isEmpty()){
            return Optional.empty();
        }

        Optional<Playlist> playlistToEdit = playlistById(id);

        if(playlistEdited.getName().isEmpty()){
            playlistEdited.setName("La mia nuova Playlist");
        }

        playlistToEdit.get().setId(id);
        playlistToEdit.get().setName(playlistEdited.getName());
        playlistToEdit.get().setOwner(playlistEdited.getOwner());
        playlistToEdit.get().setDuration(String.valueOf(playlistEdited.getDuration()));

        return Optional.of(playlistRepo.save(playlistToEdit.get()));
    }

    public void playlistDelById(Long id){
        playlistRepo.deleteById(id);
    }

}
