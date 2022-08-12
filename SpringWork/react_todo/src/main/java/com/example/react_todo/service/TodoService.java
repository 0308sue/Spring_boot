package com.example.react_todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.react_todo.model.Todo;
import com.example.react_todo.repository.TodoRepository;

@Service
public class TodoService {
	
	@Autowired
	private TodoRepository todoRepository;

	public void insert(Todo todo) {
		todoRepository.save(todo);
		
	}

	public List<Todo> list() {
		return todoRepository.findAll();
	}

	public void delete(Long num) {
		todoRepository.deleteById(num);
	}

}
