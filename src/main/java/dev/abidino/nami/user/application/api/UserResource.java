package dev.abidino.nami.user.application.api;

import dev.abidino.nami.user.domain.Role;

public record UserResource(String username, String password, Role role) {
}