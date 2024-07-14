package com.example.demo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.Login;

@RestController
@RequestMapping("/login")
public class LoginController {
    @RequestMapping("/register")
    public String register(String username, String password) {
        Login login = new Login();
        return login.addUser(username, password);
    }

    @RequestMapping("/login")
    public String login(String username, String password) {
        Login login = new Login();
        return login.login(username, password);
    }
}
