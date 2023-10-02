package com.camillakb.backend.Security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.camillakb.backend.Control.TokenController;

import ch.qos.logback.classic.Logger;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;



public class AuthorizationFilter extends OncePerRequestFilter {

    Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

    public static final String USER = "USER";
    public static final String ROLE_USER = "ROLE_" + USER;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

                logger.info("Received a request.");
        // check Bearer auth header
        final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (header == null || !header.startsWith("Bearer ")) {
            logger.info("Header does not exist.");
            filterChain.doFilter(request, response);
            return;
        }

        // if Bearer auth header exists, validate token, and extract userId from token.
        String token = header.substring(7);
        final String username = validateTokenAndGetUserId(token);
        
        if (username == null) {
            // validation failed or token expired
            filterChain.doFilter(request, response);
            logger.info("Validation failed.");
            return;
        }

        // if token is valid, add user details to the authentication context
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                username,
                null,
                Collections.singletonList(new SimpleGrantedAuthority(ROLE_USER)));
        SecurityContextHolder.getContext().setAuthentication(auth);

        // continue with authenticated user context
        filterChain.doFilter(request, response);
    }

    public String validateTokenAndGetUserId(final String token) {
        try {
            final Algorithm hmac512 = Algorithm.HMAC512(TokenController.keyStr);;
            final JWTVerifier verifier = JWT.require(hmac512).build();
            return verifier.verify(token).getSubject();

        } catch (final JWTVerificationException verificationEx) {
            logger.info("Invalid token.");
            return null;
        }
    }
}
