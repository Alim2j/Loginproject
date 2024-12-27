package org.example.loginproject;

import org.example.loginproject.model.User;
import org.example.loginproject.repository.UserRepository;
import org.example.loginproject.repository.impl.UserRepositoryImpl;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepositoryImpl();
        userRepository.save(User.builder().username("ashkj").password("lmknjbhi").build());
    }
}
