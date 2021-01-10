package com.ppleflow.challenge.hrplatform.service;


import com.ppleflow.challenge.hrplatform.model.State;
import com.ppleflow.challenge.hrplatform.model.User;
import com.ppleflow.challenge.hrplatform.repository.UserKafkaRepository;
import com.ppleflow.challenge.hrplatform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserKafkaRepository userKafkaRepository;

    @Override
    public User addUser(String name, String contractDetails) {
        User user = new User(name, contractDetails, State.ADDED);
        user = userRepository.save(user);
        userKafkaRepository.publish(user, "ADD");
        return user;
    }

    @Override
    public User updateUser(long userId, State state) {
        User user = null;
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isPresent()) {
            user = userOptional.get();
            user.setState(state);
            user = userRepository.save(user);
            userKafkaRepository.publish(user, state.name());
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
