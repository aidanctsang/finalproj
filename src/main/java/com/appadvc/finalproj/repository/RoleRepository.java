package com.appadvc.finalproj.repository;

import com.appadvc.finalproj.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByName(String name);
}
