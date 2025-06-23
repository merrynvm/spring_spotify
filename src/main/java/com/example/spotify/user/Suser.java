package com.example.spotify.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

@Entity
public class Suser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nickname;
    private Email email;
    private String password;

    @Enumerated(EnumType.STRING)
    private SuserType type;

    private Suser(){}

    private Suser(Long id, String nickname, Email email, String password, SuserType type){
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SuserType getType() {
        return type;
    }

    public void setType(SuserType type) {
        this.type = type;
    }

}
