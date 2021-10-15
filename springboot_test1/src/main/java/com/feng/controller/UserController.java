package com.feng.controller;

import com.feng.entity.User;
import com.feng.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private Users users;

    @GetMapping("/user")
    public String users() {
        return users.toString();
    }
}
