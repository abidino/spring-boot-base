package dev.abidino.nami.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserEntityRepositoryImplTest {
//    @Mock
//    UserH2Repository userH2Repository;
//    @Mock
//    PasswordEncoder passwordEncoder;
//
//    @Test
//    void whenUsernameNotFound_thenExceptionIsCorrect() {
//
//        UserEntity userEntity = new UserEntity();
//        userEntity.setUsername("abidino");
//        userEntity.setPassword("test");
//
//        UserH2RepositoryImpl userH2RepositoryImpl = new UserH2RepositoryImpl(userH2Repository, passwordEncoder);
//        Assertions.assertThrows(UsernameNotFoundException.class, () -> userH2RepositoryImpl.authenticate(userEntity));
//    }
//
//    @Test
//    void whenUsernameAndPasswordNotMatch_thenExceptionIsCorrect() {
//        UserEntity userEntity = new UserEntity();
//        userEntity.setUsername("abidino");
//        userEntity.setPassword("test");
//
//        Mockito.when(userH2Repository.findByUsername(userEntity.getUsername())).thenReturn(Optional.of(new UserEntity(null, "abidino", "test")));
//        Mockito.when(passwordEncoder.matches(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(false);
//        UserH2RepositoryImpl userH2RepositoryImpl = new UserH2RepositoryImpl(userH2Repository, passwordEncoder);
//        Assertions.assertThrows(BadRequestException.class, () -> userH2RepositoryImpl.authenticate(userEntity));
//    }
//
//    @Test
//    void whenAuthenticate_thenReturnTokenResource() {
//        UserEntity userEntity = new UserEntity();
//        userEntity.setUsername("abidino");
//        userEntity.setPassword("test");
//
//        Mockito.when(userH2Repository.findByUsername(userEntity.getUsername())).thenReturn(Optional.of(new UserEntity(5L, "abidino", "test")));
//        Mockito.when(passwordEncoder.matches(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(true);
//        UserH2RepositoryImpl userH2RepositoryImpl = new UserH2RepositoryImpl(userH2Repository, passwordEncoder);
//        TokenResource tokenResource = userH2RepositoryImpl.authenticate(userEntity);
//        Assertions.assertNotNull(tokenResource.token());
//        Assertions.assertNotNull(tokenResource.expireDate());
//    }
}
