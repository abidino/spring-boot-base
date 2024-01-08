package dev.abidino.nami.user.infrastructere;

import dev.abidino.nami.exception.BadRequestException;
import dev.abidino.nami.exception.ErrorMessageType;
import dev.abidino.nami.exception.UsernameNotFoundException;
import dev.abidino.nami.user.application.mapper.UserMapper;
import dev.abidino.nami.user.domain.User;
import dev.abidino.nami.user.domain.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRepositoryImpl implements UserRepository {


    private final UserH2Repository userH2Repository;
    private final UserMapper userMapper;

    public UserRepositoryImpl(UserH2Repository userH2Repository, UserMapper userMapper) {
        this.userH2Repository = userH2Repository;
        this.userMapper = userMapper;
    }

    @Override
    public User findByUsername(String username) {
        Optional<UserEntity> optionalUserEntity = findByOptionalUsername(username);
        UserEntity userEntity = optionalUserEntity.orElseThrow(() -> new UsernameNotFoundException("Given username not found username : " + username));
        return userMapper.toUser(userEntity);
    }

    @Override
    public User save(User user) {
        UserEntity userEntity = userMapper.toUserEntity(user);
        Optional<UserEntity> optionalUser = findByOptionalUsername(userEntity.getUsername());
        if (optionalUser.isPresent()) {
            throw new BadRequestException(ErrorMessageType.USERNAME_ALREADY_EXIST.getMessage());
        }
        UserEntity savedUserEntity = userH2Repository.save(userEntity);
        return userMapper.toUser(savedUserEntity);
    }

    @Override
    public List<User> findAll() {
        List<UserEntity> userEntities = userH2Repository.findAll();
        return userEntities.stream().map(userMapper::toUser).toList();
    }

    private Optional<UserEntity> findByOptionalUsername(String username) {
        return userH2Repository.findByUsername(username);
    }
}
