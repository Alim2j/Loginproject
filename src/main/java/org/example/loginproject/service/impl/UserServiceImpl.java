package org.example.loginproject.service.impl;

import org.example.loginproject.dto.CreateUserRequest;
import org.example.loginproject.dto.response.SignInResponse;
import org.example.loginproject.model.SignInRequest;
import org.example.loginproject.model.User;
import org.example.loginproject.repository.UserRepository;
import org.example.loginproject.repository.impl.UserRepositoryImpl;
import org.example.loginproject.service.UserService;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public void addUser(CreateUserRequest createUserRequest) {
        User user = User.builder()
                .username(createUserRequest.getUsername())
                .password(createUserRequest.getPassword()).build();
        userRepository.save(user);

    }

    @Override
    public SignInResponse signIn(SignInRequest signInRequest) {
        Optional<User> optionalUser = userRepository.signIn(signInRequest.getUsername(), signInRequest.getPassword());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return SignInResponse.builder()
                    .userId(user.getId())
                    .build();
        }
        return SignInResponse.builder().build();
    }
}
