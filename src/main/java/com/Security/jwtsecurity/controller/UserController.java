package com.Security.jwtsecurity.controller;

import com.Security.jwtsecurity.model.Users;
import com.Security.jwtsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/register")
    public Users register(@RequestBody Users users){
        return userService.register(users);
    }

    @PostMapping(path = "/login")
    public String login(@RequestBody Users users){

        return userService.verify(users);
    }
}
