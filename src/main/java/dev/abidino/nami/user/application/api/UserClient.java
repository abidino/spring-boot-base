package dev.abidino.nami.user.application.api;

import dev.abidino.nami.user.application.mapper.UserMapper;
import dev.abidino.nami.user.domain.User;
import dev.abidino.nami.user.domain.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserClient {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserClient(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    public UserResource save(UserDto userDto) {
        User user = userMapper.toUser(userDto);
        User savedUser = userService.save(user);
        return userMapper.toUserResource(savedUser);
    }

    public UserResource findByUsername(String username) {
        User user = userService.findByUsername(username);
        return userMapper.toUserResource(user);
    }

    List<UserResource> all() {
        List<User> users = userService.findAll();
        return users.stream().map(userMapper::toUserResource).toList();
    }
}
