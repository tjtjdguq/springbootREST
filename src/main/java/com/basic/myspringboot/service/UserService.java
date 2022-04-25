package com.basic.myspringboot.service;

import com.basic.myspringboot.entity.User;
import com.basic.myspringboot.exception.ResourceNotFoundException;
import com.basic.myspringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User insertUser(User user) {
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public List<User> selectAllUser() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<User> selectUser(Long id) {
        return userRepository.findById(id);
    }

    public User updateUser(Long id, User userDetail) {
        User existUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User","id",id));
        //name 필드 수정을 하기 위해서 setter method만 호출한다.
        existUser.setName(userDetail.getName());
        //email 필드 수정 하기 위해서 setter method만 호출한다.
        existUser.setEmail(userDetail.getEmail());
        return existUser;
    }
}
