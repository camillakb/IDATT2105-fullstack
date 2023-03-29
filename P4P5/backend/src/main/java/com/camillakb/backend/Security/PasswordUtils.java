package com.camillakb.backend.Security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordUtils {
    private static final int STRENGTH = 10;
    private static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder(STRENGTH);

    public static String encode(String password) {
        return PASSWORD_ENCODER.encode(password);
    }

    public static boolean matches(String password, String encodedPassword) {
        return PASSWORD_ENCODER.matches(password, encodedPassword);
    }
}
