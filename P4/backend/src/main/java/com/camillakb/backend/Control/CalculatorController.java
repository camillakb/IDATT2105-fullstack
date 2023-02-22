package com.camillakb.backend.Control;

import java.util.List;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // tar i mot REST-forespørsler
@RequestMapping("/api") // valgfri

class CalculatorController {
    @GetMapping("/user")
    //alt. -> @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> listAllUsers() { 
        
        return allUsers; }
}