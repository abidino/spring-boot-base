package dev.abidino.nami.user.application.api;

import dev.abidino.nami.NamiApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(NamiApplication.API_PREFIX + "/user")
public record UserController(UserClient userClient) {
    @GetMapping("/all")
    List<UserResource> all() {
        return userClient.all();
    }

    @PostMapping
    public UserResource save(@RequestBody UserDto userDto) {
        return userClient.save(userDto);
    }

    @GetMapping("/{username}")
    public UserResource findByUsername(@PathVariable String username) {
        return userClient.findByUsername(username);
    }
}
