package dev.abidino.nami.user.application.mapper;

import dev.abidino.nami.user.application.api.UserDto;
import dev.abidino.nami.user.application.api.UserResource;
import dev.abidino.nami.user.domain.User;
import dev.abidino.nami.user.infrastructere.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class UserMapperImpl implements UserMapper {
    @Override
    public User toUser(UserDto userDto) {
        return new User(userDto.username(), userDto.password());
    }

    @Override
    public User toUser(UserEntity userEntity) {
        return new User(userEntity.getId(), userEntity.getUsername(), userEntity.getPassword());
    }

    @Override
    public UserEntity toUserEntity(User user) {
        return new UserEntity(user.getId(), user.getUsername(), user.getPassword());
    }

    @Override
    public UserResource toUserResource(User user) {
        return new UserResource(user.getUsername(), user.getPassword());
    }
}
