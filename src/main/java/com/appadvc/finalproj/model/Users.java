package com.appadvc.finalproj.model;

import com.appadvc.finalproj.dto.UserDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userID;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "users", cascade = CascadeType.REMOVE)
    private List<Orders> orders;

    public Users(Long userID) {
        this.userID = userID;
    }

    public Users(UserDTO userDTO) {
        this.userID = userDTO.getUserID();
        this.username = userDTO.getUsername();
        this.password = userDTO.getPassword();
        this.address = userDTO.getAddress();
        this.email = userDTO.getEmail();
    }
}
