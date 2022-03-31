package com.appadvc.finalproj.controller;

import com.appadvc.finalproj.dto.UserDTO;
import com.appadvc.finalproj.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("register")
public class RegisterController {
    private static final String CUSTOMER_ROLE = "ROLE_CUSTOMER";

    @Autowired
    private UserService userService;

    @GetMapping
    private String index(Model model) {
        model.addAttribute("user", new UserDTO());
        return "register/loginpage";
    }

    @PostMapping
    private String register(UserDTO userDTO, Model model) {
        userDTO.setRole(CUSTOMER_ROLE);
        userService.add(userDTO);
        return "redirect:/login";
    }
}
