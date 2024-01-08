package dev.abidino.nami.user.domain;

import java.util.List;

public interface UserService {
    User save(User user);

    List<User> findAll();

    User findByUsername(String username);
}
