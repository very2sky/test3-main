package com.example.test3.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class SecurityService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException{
        return null;
    }
}
