package com.camillakb.backend.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSec) throws Exception {
        return httpSec
            .csrf().disable()
            .cors().and()
            .authorizeHttpRequests()
                .requestMatchers("/token", "/user").permitAll()
                .requestMatchers("/calculator").authenticated()
                .anyRequest().authenticated().and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
            .addFilterBefore(new AuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
            .build();
    }
}
