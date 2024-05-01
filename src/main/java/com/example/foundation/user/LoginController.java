package com.example.foundation.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(String username, String password, Model model) {
        if (userService.authenticate(username, password)) {
            // 로그인 성공 시
            return "redirect:/home";
        } else {
            // 로그인 실패 시
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }
}
