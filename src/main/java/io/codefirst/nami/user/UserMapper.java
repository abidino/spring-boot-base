package io.codefirst.nami.user;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
interface UserMapper {
    User toUser(UserDto userDto);

    List<User> toUser(List<UserDto> userDto);

    UserResource toUserResource(User user);

    List<UserResource> toUserResource(List<User> user);
}
