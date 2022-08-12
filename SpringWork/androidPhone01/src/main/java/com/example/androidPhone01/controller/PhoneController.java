package com.example.androidPhone01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.androidPhone01.model.Phone;
import com.example.androidPhone01.service.PhoneService;

@RestController
public class PhoneController {
	
	@Autowired
	private PhoneService pservice;
	
	@PostMapping("/insert")
	public Phone insert(@RequestBody Phone phone) {
		System.out.println("aaa");
		return pservice.insert(phone);
	}
	
	@GetMapping("/list")
	public List<Phone> list(){
		return pservice.list();
	}
	
	@DeleteMapping("/delete/{num}")
	public void delete(@PathVariable Long num) {
		pservice.delete(num);
	}
	
	@PutMapping("update/{id}")
	public Phone update(@PathVariable Long id,@RequestBody Phone phone) {
		return pservice.update(id,phone);
	}

}
