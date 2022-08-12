package com.example.react_todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.react_todo.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
