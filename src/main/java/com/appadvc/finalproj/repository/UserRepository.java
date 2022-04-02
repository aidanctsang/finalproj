package com.appadvc.finalproj.repository;

import com.appadvc.finalproj.model.Users;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends CrudRepository<Users, Long> {
    Users findByEmail(String email);

    @Transactional
    @Modifying
    @Query("update Users u set u.passwordHash = :passwordHash where u.userID = :userID")
    void updatePassword(@Param(value = "userID") long userID, @Param(value = "passwordHash") String passwordHash);
}
