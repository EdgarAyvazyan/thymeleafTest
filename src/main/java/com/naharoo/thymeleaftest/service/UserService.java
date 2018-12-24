package com.naharoo.thymeleaftest.service;

import com.naharoo.thymeleaftest.domain.User;
import com.naharoo.thymeleaftest.entity.UserEntity;
import com.naharoo.thymeleaftest.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserEntity> userOpt = userRepository.findUserByUsernameIgnoreCase(username);


        if (!userOpt.isPresent()) {
            final String errorMsg = "Username doesn't exist";
            log.error(errorMsg);
            throw new UsernameNotFoundException(errorMsg);
        }

        return entityToDomain(userOpt.get());

    }

    public List<User> getAllUsers() {

        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .map(this::entityToDomain)
                .collect(Collectors.toList());
    }

    public User createUser(User user) {

        UserEntity userEntity = domainToEntity(user);

        UserEntity result = userRepository.save(userEntity);

        return entityToDomain(result);
    }

    private UserEntity domainToEntity(User domain) {

        UserEntity entity = new UserEntity();

        entity.setId(domain.getId());
        entity.setUsername(domain.getUsername());
        entity.setPassword(domain.getPassword());

        return entity;
    }

    private User entityToDomain(UserEntity entity) {

        User domain = new User();

        domain.setId(entity.getId());
        domain.setUsername(entity.getUsername());
        domain.setPassword(entity.getPassword());

        return domain;
    }
}
