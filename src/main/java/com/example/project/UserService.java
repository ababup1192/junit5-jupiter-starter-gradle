package com.example.project;

import java.util.List;
import java.util.Optional;

public class UserService {
    private final List<User> userRepository;

    public UserService(List<User> userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository;
    }

    public Optional<User> getFirstUser() {
        return userRepository.stream().findFirst();
    }

    public Optional<User> findByLastName(String lastName) {
        return userRepository.stream().filter(user -> user.getLastName().equals(lastName)).findFirst();
    }

    public Optional<User> findByFirstName(String firstName) {
        return userRepository.stream().filter(user -> user.getFirstName().equals(firstName)).findFirst();
    }
}
