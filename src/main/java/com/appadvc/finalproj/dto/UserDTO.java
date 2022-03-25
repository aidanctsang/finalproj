package com.appadvc.finalproj.dto;

import com.appadvc.finalproj.model.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long userID;

    private String username;

    private String password;

    private String address;

    private String email;

    public UserDTO(Users user) {
        this.userID = user.getUserID();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.address = user.getAddress();
        this.email = user.getEmail();
    }
}
