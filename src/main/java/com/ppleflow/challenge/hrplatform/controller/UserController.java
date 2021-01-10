package com.ppleflow.challenge.hrplatform.controller;

import com.ppleflow.challenge.hrplatform.model.State;
import com.ppleflow.challenge.hrplatform.model.User;
import com.ppleflow.challenge.hrplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path="/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(path = "/add/{name}/{contractDetails}", consumes = "application/json", produces = "application/json")
    @ResponseStatus(value = HttpStatus.OK)
    public User addUser(@PathVariable String name, @PathVariable String contractDetails) {
        return userService.addUser(name, contractDetails);
    }

    @PutMapping(path = "/update/{userId}/{state}", consumes = "application/json", produces = "application/json")
    @ResponseStatus(value = HttpStatus.OK)
    public User updateUser(@PathVariable long userId, @PathVariable State state) {
        return userService.updateUser(userId, state);
    }

    @GetMapping(path = "/getall", consumes = "application/json", produces = "application/json")
    @ResponseStatus(value = HttpStatus.OK)
    public List<User> findAll() {
        return userService.getAllUsers();
    }
}
