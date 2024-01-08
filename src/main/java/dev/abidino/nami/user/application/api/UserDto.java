package dev.abidino.nami.user.application.api;

import jakarta.validation.constraints.NotNull;

public record UserDto(@NotNull(message = "Username cannot be null") String username,
                      @NotNull(message = "Password cannot be null") String password) {
}
