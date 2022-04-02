package com.appadvc.finalproj.controller;

import com.appadvc.finalproj.dto.UserDTO;
import com.appadvc.finalproj.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("forgot-password")
public class ForgotPasswordController {
    @Autowired
    private UserService userService;

    @GetMapping
    private String index(Model model) {
        model.addAttribute("user", new UserDTO());
        return "forgot-password/index";
    }

    @PostMapping
    private String forgotPassword(@Valid @ModelAttribute("user") UserDTO user, BindingResult bindingResult, Model model) {
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            bindingResult.rejectValue("password", "invalid.confirm.password", "Password and Confirm Password fields must be the same.");
            model.addAttribute("user", user);
            return "forgot-password/index";
        }

        userService.resetPassword(user);
        return "redirect:/login";
    }
}
