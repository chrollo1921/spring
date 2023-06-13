package com.example.springjwtsecurity.repository;

import com.example.springjwtsecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    public User findByUsername(String username);
}
