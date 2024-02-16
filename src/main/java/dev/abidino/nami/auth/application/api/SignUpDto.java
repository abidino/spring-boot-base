package dev.abidino.nami.auth.application.api;

import dev.abidino.nami.user.domain.Role;
import jakarta.validation.constraints.NotNull;

public record SignUpDto(@NotNull(message = "Username cannot be null") String username,
                        @NotNull(message = "Password cannot be null") String password,
                        @NotNull(message = "Role cannot be null") Role role) {
}
