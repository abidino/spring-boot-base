package dev.abidino.nami.user.domain;

import java.util.UUID;

public class User {
    private String id;

    private String username;

    private String password;

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public User(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void initialize() {
        this.id = UUID.randomUUID().toString();
    }
}
