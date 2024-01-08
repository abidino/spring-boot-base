package dev.abidino.nami.auth.application.api;

import jakarta.validation.constraints.NotNull;

public record LoginDto(@NotNull(message = "Username cannot be null") String username,
                       @NotNull(message = "Password cannot be null") String password) {
}
