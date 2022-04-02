package com.appadvc.finalproj.services.impl;

import com.appadvc.finalproj.dto.UserDTO;
import com.appadvc.finalproj.model.Users;
import com.appadvc.finalproj.repository.RoleRepository;
import com.appadvc.finalproj.repository.UserRepository;
import com.appadvc.finalproj.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<UserDTO> list() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .map(UserDTO::new )
                .collect(Collectors.toList());
    }

    @Override
    public void add(UserDTO user) {
        Users users = new Users(user);
        users.setRole(roleRepository.findByName(user.getRole()));
        users.setPasswordHash(passwordEncoder.encode(user.getPassword()));
        userRepository.save(users);
    }

    @Override
    public UserDTO get(Long userID) {
        return new UserDTO(userRepository.findById(userID).get());
    }

    @Override
    public void update(UserDTO updatedUser) {
        userRepository.save(new Users(updatedUser));
    }

    @Override
    public void delete(Long userID) {
        userRepository.deleteById(userID);
    }

    @Override
    public UserDTO validateUser(String email, String password) {
        Users user = userRepository.findByEmail(email);

        if (passwordEncoder.matches(password, user.getPasswordHash())) {
            return new UserDTO(user);
        } else {
            return null;
        }
    }

    @Override
    public boolean resetPassword(UserDTO user) {
        Users userModel = userRepository.findByEmail(user.getEmail());

        if (userModel == null) {
            return false;
        } else {
            userRepository.updatePassword(userModel.getUserID(), passwordEncoder.encode(user.getPassword()));
            return true;
        }
    }
}
