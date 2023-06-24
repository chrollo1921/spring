package com.springbootsecurity.controller;

import com.springbootsecurity.model.User;
import com.springbootsecurity.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getusers")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/getuser/{username}")
    public User getUserByName(@PathVariable String username){
        return userService.getUserwithName(username);
    }

    @PostMapping("/saveuser")
    public User saveUser(@RequestBody  User user){
        return userService.saveUser(user);
    }

}
