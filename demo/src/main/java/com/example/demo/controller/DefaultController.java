package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.naming.AuthenticationException;

@Controller
@RequestMapping("")
public class DefaultController {

    UserRepository repository;

    public DefaultController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/home")
    public String home(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) throws AuthenticationException {
        User user = repository.findByUsername(username);
        if (user == null)
            throw new AuthenticationException("User does not exist");
        if (!user.getPassword().equals(password))
            throw new AuthenticationException("Wrong password");
        return "index";
    }


}
