package com.Warehouse.SecurityConfig;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

    public static void main(String[] args){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String rawPassword = "asappunya";
        String encodedPassword = bCryptPasswordEncoder.encode(rawPassword);

        System.out.println(encodedPassword);
    }
}
