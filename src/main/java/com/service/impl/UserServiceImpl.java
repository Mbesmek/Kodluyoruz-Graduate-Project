package com.service.impl;

import com.entity.User;
import com.repository.UserRepository;
import com.service.UserService;
import com.service.model.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public boolean loginControl(UserContext context) {
        List<User> user=userRepository.find(context.getUserName());
        String enteredPassword= context.getUserPassword();
        String dbPassword=user.get(0).getUserPassword();
        return dbPassword.equals(enteredPassword);
    }
}
