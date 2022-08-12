package com.example.react_todo_router.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.react_todo_router.dto.Todo;
import com.example.react_todo_router.service.TodoService;

@RestController
public class HomeController {
	
	@Autowired
	private TodoService todoService;
	
	@PostMapping("/todo/insert")
	public String insert(@RequestBody Todo todo) {
		todoService.insert(todo);
		return "success";
	}
	
	@GetMapping("/todo/list")
	public List<Todo> list(){
		return todoService.list();
	}
	
	@DeleteMapping("todo/delete/{num}")
	public String delete(@PathVariable int num) {
		todoService.delete(num);
		return "success";
	}
	
	@GetMapping("todo/get/{num}")
	public Todo update(@PathVariable int num) {
		return todoService.view(num);
	}
	
	@PostMapping("/todo/update")
	public String update(@RequestBody Todo todo) {
		todoService.update(todo);
		return "success";
	}
	
	@GetMapping("/todo/search")
	public List<Todo> search(String word){
		return todoService.search(word);
	}
	
	

}
