package com.basic.myspringboot.controller;

import com.basic.myspringboot.entity.User;
import com.basic.myspringboot.exception.ResourceNotFoundException;
import com.basic.myspringboot.service.UserService;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    private UserService userService;

    //Constructor Injection (생성자 주입 방식)
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    //POST http://localhost:8087/api/users
    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.insertUser(user);
    }

    //GET http://localhost:8087/api/users
    @GetMapping
    public List<User> getUsers(){
        return userService.selectAllUser();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        Optional<User> optionalUser = userService.selectUser(id);
        //orElseThrow의 아규먼트 타입 Supplier 
        //Supplier의 추상메서드 T get()
        User existUser = optionalUser.orElseThrow(() -> new ResourceNotFoundException("User","id",id));
        return existUser;
    }


}
