package com.appadvc.finalproj.model;

import com.appadvc.finalproj.dto.UserDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    private String passwordHash;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false, unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    public Users(Long userID) {
        this.userID = userID;
    }

    public Users(UserDTO userDTO) {
        this.userID = userDTO.getUserID();
        this.username = userDTO.getUsername();
        this.address = userDTO.getAddress();
        this.email = userDTO.getEmail();
    }
}
