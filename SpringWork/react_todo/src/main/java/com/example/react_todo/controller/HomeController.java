package com.example.react_todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.react_todo.model.Todo;
import com.example.react_todo.service.TodoService;

@RestController
public class HomeController {
	
	@Autowired
	private TodoService todoService;
	
	@PostMapping("todo/insert")
	public String insert(@RequestBody Todo todo) {
		todoService.insert(todo);
		return "success";
	}
	
	@GetMapping("todo/list")
	public List<Todo> list(){
		return todoService.list();
	}
	
	@DeleteMapping("todo/delete/{num}")
	public String delete(@PathVariable Long num) {
		todoService.delete(num);
		return "success";
	}
	

}
