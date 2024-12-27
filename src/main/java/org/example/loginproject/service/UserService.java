package org.example.loginproject.service;

import org.example.loginproject.dto.CreateUserRequest;
import org.example.loginproject.dto.response.SignInResponse;
import org.example.loginproject.model.SignInRequest;
import org.example.loginproject.model.User;

import java.util.Optional;

public interface UserService {
    void addUser(CreateUserRequest createUserRequest);
    SignInResponse signIn(SignInRequest signInRequest);
}
