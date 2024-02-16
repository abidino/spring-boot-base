package dev.abidino.nami.user.application.api;

import dev.abidino.nami.NamiApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(NamiApplication.API_PREFIX + "/user")
public class UserController {

    private final UserClient userClient;

    public UserController(UserClient userClient) {
        this.userClient = userClient;
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole(ADMIN)")
    List<UserResource> all(Authentication authentication) {
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
