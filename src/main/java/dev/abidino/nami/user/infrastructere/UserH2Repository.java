package dev.abidino.nami.user.infrastructere;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserH2Repository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);
}
