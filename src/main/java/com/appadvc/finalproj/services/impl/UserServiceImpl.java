package com.appadvc.finalproj.services.impl;

import com.appadvc.finalproj.dto.UserDTO;
import com.appadvc.finalproj.model.Users;
import com.appadvc.finalproj.repository.UserRepository;
import com.appadvc.finalproj.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserDTO> list() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .map(UserDTO::new )
                .collect(Collectors.toList());
    }

    @Override
    public void add(UserDTO user) {
        userRepository.save(new Users(user));
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
}
