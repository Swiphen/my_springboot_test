package com.feng.controller;

import com.feng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/get")
    public String getUserById(Integer id) {
        return userService.getUserById(id);
    }

    @GetMapping("/delete")
    public void deleteUserById(Integer id) {
        userService.deleteUserById(id);
    }
}
