package dev.abidino.nami.user.domain;

import java.util.List;

public interface UserRepository {
    List<User> findAll();

    User save(User user);

    User findByUsername(String username);
}
