package org.example.loginproject.repository;

import org.example.loginproject.model.User;

import java.util.Optional;

public interface UserRepository extends BaseRepository<User, Long> {
    Optional<User> signIn(String username,String password);
}
