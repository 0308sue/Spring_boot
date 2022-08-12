package com.react.reactmytodojpa2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.react.reactmytodojpa2.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {

	List<Todo> findByTitleContaining(String title);

}
