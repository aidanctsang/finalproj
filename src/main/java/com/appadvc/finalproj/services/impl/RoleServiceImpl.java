package com.appadvc.finalproj.services.impl;

import com.appadvc.finalproj.repository.RoleRepository;
import com.appadvc.finalproj.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Long getRoleId(String name) {
        return roleRepository.findByName(name).getId();
    }
}
