package com.example.spotify.song;

import com.example.spotify.user.Suser;
import com.example.spotify.user.SuserRepo;
import com.example.spotify.user.SuserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {
    @Autowired private SongRepo songRepo;
    @Autowired private SuserRepo suserRepo;

    public List<Song> allSongs(){
        return songRepo.findAll();
    }

    public Optional<Song> createSong(Song newSong){
        if(newSong.getName().isEmpty() || newSong.getDuration() == null || newSong.getArtist().isEmpty()
                                    || newSong.getGenre() == null || newSong.getRelease_date() == null){
            return Optional.empty();

        }

        Optional<Suser> suserFound = suserRepo.findByNickname(newSong.getArtist());

        if(suserFound.isEmpty() || suserFound.get().getType().equals(SuserType.USER)){
            return Optional.empty();
        }

        return Optional.of(songRepo.save(newSong));
    }

    public Optional<Song> songById(Long id){
        return songRepo.findById(id);
    }

    public Optional<Song> updateById(Long id, Song updatedSong){

        if(updatedSong.getName().isEmpty() || updatedSong.getDuration() == null || updatedSong.getArtist().isEmpty()
                || updatedSong.getGenre() == null || updatedSong.getRelease_date() == null){
            return Optional.empty();

        }


        Optional<Suser> suserFound = suserRepo.findByNickname(updatedSong.getArtist());

        if(suserFound.isEmpty() || suserFound.get().getType().equals(SuserType.USER)){
            return Optional.empty();
        }

        Optional<Song> songFound = songRepo.findById(id);

        songFound.get().setName(updatedSong.getName());
        songFound.get().setDuration(updatedSong.getDuration());
        songFound.get().setArtist(updatedSong.getArtist());
        songFound.get().setGenre(updatedSong.getGenre());
        songFound.get().setRelease_date(updatedSong.getRelease_date());

        return Optional.of(songRepo.save(songFound.get()));
    }

    public void deleteById(Long id){
        songRepo.deleteById(id);
    }

}
