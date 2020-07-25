package com.projecto.saude.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.projecto.saude.Models.User;
import com.projecto.saude.web.UserRegistrationDto;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}
