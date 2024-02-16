package dev.abidino.nami.user.infrastructere;

import dev.abidino.nami.user.domain.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

@Entity
public class UserEntity {
    @Id
    private String id;

    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    public UserEntity(String id, String username, String password, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public UserEntity() {

    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
