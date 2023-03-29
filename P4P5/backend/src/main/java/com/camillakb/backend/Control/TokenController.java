package com.camillakb.backend.Control;

import java.time.Duration;
import java.time.Instant;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.camillakb.backend.DAO.UserRepo;
import com.camillakb.backend.Entity.User;
import com.camillakb.backend.Model.LoginRequest;
import com.camillakb.backend.Security.PasswordUtils;

@RestController()
@EnableAutoConfiguration
@CrossOrigin
@RequestMapping(path = "/token")
public class TokenController {
    public static final String keyStr = "oooooverysecret";
    private static final Duration JWT_TOKEN_VALIDITY = Duration.ofMinutes(5);
    private static final String issuer_id = "Calculator";

    @Autowired
    private UserRepo userRepo;

    Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

    @PostMapping(value = "")
    @ResponseStatus(value = HttpStatus.CREATED)
    public String getToken(final @RequestBody LoginRequest loginRequest) {
        User user = userRepo.findById(loginRequest.username()).orElseThrow();

        if (PasswordUtils.matches(loginRequest.password(), user.getPassword())) {
            return generateToken(loginRequest.username());
        
        } else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
    }

    public String generateToken(final String username) {
        final Instant now = Instant.now();
        final Algorithm hmac512 = Algorithm.HMAC512(keyStr);

        String result = JWT.create()
            .withSubject(username)
            .withIssuer(TokenController.issuer_id)
            .withIssuedAt(now) 
            .withExpiresAt(now.plus(TokenController.JWT_TOKEN_VALIDITY))
            .sign(hmac512);

        return result;
    }
}
