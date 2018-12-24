package com.naharoo.thymeleaftest.repo;

import com.naharoo.thymeleaftest.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

    Optional<UserEntity> findUserByUsernameIgnoreCase(String username);
}
