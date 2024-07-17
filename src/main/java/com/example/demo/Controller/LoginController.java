package com.example.demo.Controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Repository.Login;

@RestController
@RequestMapping("/login")
public class LoginController {
    static class LoginInfo {
        private String username;
        private String password;
        public String getUsername(){
            return username;
        }
        public void setUsername(String username){
            this.username = username;
        }
        public String getPassword(){
            return password;
        }

    }

    @RequestMapping("/register")
    public String register(String username, String password) {
        Login login = new Login();
        return login.addUser(username, password);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginInfo loginInfo) {
        System.out.println("Received username: " + loginInfo.getUsername() + " and password: " + loginInfo.getPassword());

        Login login = new Login();
        return login.login(loginInfo.getUsername(), loginInfo.getPassword());
    }
}
