package com.thy.frontback.User.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.thy.frontback.User.DTO.CreateUserDTO;
import com.thy.frontback.User.DTO.UpdateUserDTO;
import com.thy.frontback.User.Entities.User;
import com.thy.frontback.User.Repository.UserRepo;

@Service
public class UserService {
    private final UserRepo repo;

    public UserService(UserRepo repo) {
        this.repo = repo;
    }

    public List<User> getAll() {
        return repo.findAll();
    }

    public User getUser(long id) {
        return this.repo.findById(id).orElseThrow();
    }

    public User create(CreateUserDTO dto) {
        User user = new User();

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());

        return this.repo.save(user);
    }

    public User update(Long id, UpdateUserDTO dto) {
        User user = repo.findById(id).orElseThrow();

        if (dto.getName() != null)
            user.setName(dto.getName());
        if (dto.getPassword() != null)
            user.setPassword(dto.getPassword());

        return repo.save(user);
    }

    public boolean delete(long id) {
        try {
            repo.deleteById(id);
            return true;
        } catch (ArithmeticException e) {
            throw e;
        }
    }

}
