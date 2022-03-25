package com.appadvc.finalproj.controller;

import com.appadvc.finalproj.dto.UserDTO;
import com.appadvc.finalproj.model.Users;
import com.appadvc.finalproj.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    private String list(Model model) {
        model.addAttribute("users", userService.list());
        return "user/index";
    }

    @GetMapping("/loginpage")
    private String redirectPage(Model model) {
        model.addAttribute("user", new Users());
        return "login/loginpage";
    }

    @GetMapping("/registerpage")
    private String registerUser(Model model) {
        model.addAttribute("user", new Users());
        return "login/registerpage";
    }

    /*
     * @GetMapping("/add")
     * private String getProductAddForm(Model model) {
     * model.addAttribute("user", new UserDTO());
     * return "user/add-user";
     * }
     */

    @PostMapping
    private String add(UserDTO user, Model model) {
        userService.add(user);
        return list(model);
    }

    @GetMapping("/{userID}")
    private String getProduct(@PathVariable Long userID, Model model) {
        model.addAttribute("user", userService.get(userID));
        return "user/view-user";
    }

    @PutMapping
    private String updateUser(UserDTO user, Model model) {
        userService.update(user);
        return list(model);
    }

    @DeleteMapping
    private String deleteProduct(UserDTO user, Model model) {
        userService.delete(user.getUserID());
        return list(model);
    }
}
