package com.example.demospringboot.controller;

import com.example.demospringboot.entity.User;
import com.example.demospringboot.service.LoginService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/")
    public String home() {

        return "redirect:/login";

    }

    @GetMapping("/login")
    public String loginPage() {

        return "login";

    }

    @PostMapping("/login")
    public String login(
            @RequestParam String username,
            @RequestParam String password,
            HttpSession session) {

        User user =
                loginService.login(username);

        if(user != null &&
           user.getPassword().equals(password)) {

            session.setAttribute(
                    "user",
                    user);

            return "redirect:/dashboard";
        }

        return "login";
    }

    @GetMapping("/logout")
    public String logout(
            HttpSession session) {

        session.invalidate();

        return "redirect:/login";
    }
}