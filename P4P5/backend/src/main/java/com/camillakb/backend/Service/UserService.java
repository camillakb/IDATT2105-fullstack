package com.camillakb.backend.Service;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camillakb.backend.DAO.UserRepo;
import com.camillakb.backend.Entity.User;
import com.camillakb.backend.Model.LoginRequest;
import com.camillakb.backend.Security.PasswordUtils;

import ch.qos.logback.classic.Logger;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

    public boolean createUser(LoginRequest loginRequest) {
        User user = new User();
        user.setUsername(loginRequest.username());
        user.setPassword(PasswordUtils.encode(loginRequest.password())); 

        if (userRepo.findById(user.getUsername()).isPresent()) {
            logger.info("The user " + loginRequest.username() + " already exists.");
            return false;
        }

        userRepo.save(user);
        logger.info("Saving new user " + loginRequest.username() + " to repo.");
        return true;
    }
}
