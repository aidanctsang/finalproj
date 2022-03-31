package com.appadvc.finalproj.dto;

import com.appadvc.finalproj.model.Users;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long userID;

    private String username;

    private String password;

    private String confirmPassword;

    private String address;

    private String email;

    private String role;

    public UserDTO(Users user) {
        this.userID = user.getUserID();
        this.username = user.getUsername();
        this.address = user.getAddress();
        this.email = user.getEmail();
        this.role = user.getRole().getName();
    }
}
