package com.example.spotify.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class SuserController {
    @Autowired private SuserService suserService;

    @GetMapping("/all")
    public List<Suser> allUsers(){
        return suserService.allUsers();
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody Suser registration){
        Optional<Suser> newUser = suserService.registerUser(registration);

        if(newUser.isPresent()){
            return ResponseEntity.ok(newUser.get());
        } else {
            return ResponseEntity.badRequest().body("Inserisci tutti i campi obbligatori");
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Suser> userFound = suserService.userById(id);

        if(userFound.isPresent()){
            return ResponseEntity.ok(userFound.get());
        } else {
            return ResponseEntity.badRequest().body("L'id inserito non è valido");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody Suser updateUser){
        if(suserService.userById(id).isPresent()){
           return ResponseEntity.ok(suserService.updateById(id, updateUser));
        } else {
            return ResponseEntity.badRequest().body("L'id inserito non è valido oppure i campi obbligatori non sono stati inseriti");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        if(suserService.userById(id).isPresent()){
            suserService.deleteById(id);
            return ResponseEntity.ok("Utente eliminato");
        }else {
            return ResponseEntity.badRequest().body("L'id dell'utente fornito è errato o invalido");
        }
    }

}
