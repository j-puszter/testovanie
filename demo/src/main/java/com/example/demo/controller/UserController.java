package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<User> getById(@PathVariable Integer id) throws Exception {
        return ResponseEntity.ok(repository.findById(id).orElseThrow(() -> new Exception("User not found!")));
    }

    @GetMapping("/list")
    public ResponseEntity<List<User>> list() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<User> create(@RequestBody User user) {
        return ResponseEntity.ok(repository.save(user));
    }

    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id) {
        repository.deleteById(id);
    }

}
