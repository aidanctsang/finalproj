package com.appadvc.finalproj.repository;

import com.appadvc.finalproj.model.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users, Long> {
}
