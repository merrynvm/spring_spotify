package com.example.spotify.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuserService {
    @Autowired private SuserRepo suserRepo;

    public List<Suser> allUsers(){
        return suserRepo.findAll();
    }

    public Optional<Suser> registerUser(Suser newUser){
        //se non sono presenti i campi ritorna empty
        if(newUser.getEmail().isEmpty() && newUser.getNickname().isEmpty() && newUser.getPassword().isEmpty() && newUser.getType() == null){
            return Optional.empty();
        }

        return Optional.of(suserRepo.save(newUser));
    }

    public Optional<Suser> userById(Long id){
        return suserRepo.findById(id);
    }

    public Optional<Suser> updateById(Long id, Suser updatedUser){
        //se l`id inserito non esiste torna empty
        if(suserRepo.findById(id).isEmpty()){
            return Optional.empty();
        }

        //se i campi da aggiornare sono assenti ritorna empty
        if(updatedUser.getEmail().isEmpty() && updatedUser.getNickname().isEmpty() && updatedUser.getPassword().isEmpty() && updatedUser.getType() == null){
            return Optional.empty();
        }

        //salvo l`utente che deve essere aggiornato
        Optional<Suser> userFound = suserRepo.findById(id);

        //imposto i nuovi campi all`utente trovato
        userFound.get().setNickname(updatedUser.getNickname());
        userFound.get().setEmail(updatedUser.getEmail());
        userFound.get().setPassword(updatedUser.getPassword());
        userFound.get().setType(updatedUser.getType());

        return Optional.of(suserRepo.save(userFound.get()));

    }

    public boolean deleteById(Long id){
        if(suserRepo.findById(id).isEmpty()){
          return false;
        }

        suserRepo.deleteById(id);
        return true;
    }

}
