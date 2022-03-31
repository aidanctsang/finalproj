package com.appadvc.finalproj.services;

import com.appadvc.finalproj.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> list();

    void add(UserDTO user);

    UserDTO get(Long userID);

    void update(UserDTO updatedUser);

    void delete(Long userID);

    UserDTO validateUser(String email, String password);
}
