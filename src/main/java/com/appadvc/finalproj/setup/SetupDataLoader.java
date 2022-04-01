package com.appadvc.finalproj.setup;

import com.appadvc.finalproj.model.Role;
import com.appadvc.finalproj.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = false;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (alreadySetup)
            return;

        createRoleIfNotFound("ROLE_ADMIN");
        createRoleIfNotFound("ROLE_SELLER");
        createRoleIfNotFound("ROLE_CUSTOMER");

        alreadySetup = true;
    }

    @Transactional
    Role createRoleIfNotFound(String name) {

        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role(name);
            roleRepository.save(role);
        }

        return role;
    }
}
