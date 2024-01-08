package dev.abidino.nami.user.application.mapper;


import dev.abidino.nami.user.application.api.UserDto;
import dev.abidino.nami.user.application.api.UserResource;
import dev.abidino.nami.user.domain.User;
import dev.abidino.nami.user.infrastructere.UserEntity;

public interface UserMapper {
    User toUser(UserDto userDto);

    User toUser(UserEntity userEntity);

    UserEntity toUserEntity(User user);

    UserResource toUserResource(User user);

}
