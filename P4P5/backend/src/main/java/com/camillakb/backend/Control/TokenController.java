package com.camillakb.backend.Control;

import java.time.Duration;
import java.time.Instant;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.camillakb.backend.Model.LoginRequest;

@RestController
@RequestMapping(value = "/token")
@EnableAutoConfiguration
@CrossOrigin("*")

public class TokenController {
    public static final String keyStr = "oooooverysecret";
    private static final Duration JWT_TOKEN_VALIDITY = Duration.ofMinutes(5);
    private static final String issuer_id = "Calculator";

    Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

    @PostMapping(value = "")
    @ResponseStatus(value = HttpStatus.CREATED)

    public String getToken(final @RequestBody LoginRequest loginRequest) throws Exception {
        try {
            //sjekk at brukernavn og passord er gyldig
            //if (passord og brukernavn er gyldig): generer og returner token
            
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        // returner feilmelding hvis bruker/passord ikke er gyldig

        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
    }

    public String generateToken(final String username) {
        final Instant now = Instant.now();
        final Algorithm hmac512 = Algorithm.HMAC512(keyStr);

        String result = JWT.create()
            .withSubject(username)
            .withIssuer(TokenController.issuer_id)
            .withIssuedAt(now) //why???
            .withExpiresAt(now.plus(TokenController.JWT_TOKEN_VALIDITY))
            .sign(hmac512);

        return result;
    }
}
