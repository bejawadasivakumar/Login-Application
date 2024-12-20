package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Userdto;
import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User save(Userdto userdto) {
        User user = new User(userdto.getFullname(), userdto.getUsername(), userdto.getPassword());
        return userRepository.save(user);
    }

	
}
