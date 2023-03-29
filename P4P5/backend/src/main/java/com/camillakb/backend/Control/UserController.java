package com.camillakb.backend.Control;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.camillakb.backend.Model.LoginRequest;
import com.camillakb.backend.Service.UserService;

import ch.qos.logback.classic.Logger;

@RestController()
@RequestMapping(path = "/user")
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

    @PostMapping(path = "")
    @ResponseBody
    public boolean creatingUser(@RequestBody LoginRequest login) {
        logger.info("Trying to create user for " + login.username());
        return userService.createUser(login);
    }
}
