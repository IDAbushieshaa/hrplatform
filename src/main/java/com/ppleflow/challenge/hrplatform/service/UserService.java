package com.ppleflow.challenge.hrplatform.service;


import com.ppleflow.challenge.hrplatform.model.User;

import java.util.List;

public interface UserService {

    User addUser(String name, String contractDetails);
    User updateUser(long userId);
    List<User> getAllUsers();
}
