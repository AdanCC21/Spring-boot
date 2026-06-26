package com.thy.frontback.User.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thy.frontback.User.DTO.CreateUserDTO;
import com.thy.frontback.User.DTO.UpdateUserDTO;
import com.thy.frontback.User.Entities.User;
import com.thy.frontback.User.Service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<User> getAll() {
        return this.service.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return this.service.getUser(id);
    }

    @PostMapping
    public User create(@RequestBody CreateUserDTO userDto) {
        return this.service.create(userDto);
    }

    @PatchMapping("/{id}")
    public User update(@PathVariable Long id, UpdateUserDTO dto) {
        return this.service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return this.service.delete(id);
    }

}
