package com.naharoo.thymeleaftest.controller;

import com.naharoo.thymeleaftest.domain.User;
import com.naharoo.thymeleaftest.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PreAuthorize("permitAll()")
    @PostMapping(value = "/register")
    public ResponseEntity<?> createUser(@RequestBody User user) {

        return ResponseEntity.ok(userService.createUser(user));
    }
}
