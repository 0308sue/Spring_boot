package com.example.demo4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo4.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);
}
