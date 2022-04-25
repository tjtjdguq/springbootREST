package com.basic.myspringboot.controller;

import com.basic.myspringboot.entity.User;
import com.basic.myspringboot.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {
    private UserService userService;

    //Constructor Injection (생성자 주입 방식)
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    //http://localhost:8087/users
    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        return userService.insertUser(user);
    }


}
