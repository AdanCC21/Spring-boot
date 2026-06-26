package com.thy.frontback.User.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thy.frontback.User.Entities.User;

public interface UserRepo extends JpaRepository<User, Long> {

}
