package com.example.parkingtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.parkingtest.model.Car;
import com.example.parkingtest.repository.CarRepository;
import com.example.parkingtest.service.CarService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CarController {
	@Autowired
	private CarService carService;
	
	private final CarRepository carRepository;

	@GetMapping("/")
	public String home() {
		return "insertCar";
	}
	
	@PostMapping("/insert")
	@ResponseBody
	public String insert(@RequestBody Car car) {
		carService.save(car);
		carService.parkingtypeset(car);
		return "success";
	}
	
	@GetMapping("/list")
	public String list(Model model,
			@PageableDefault(size = 5,sort = "intime",direction = Direction.DESC) Pageable pageable,
			@RequestParam(required = false,defaultValue = "")String field,
			@RequestParam(required = false,defaultValue = "")String word) {
		Page<Car> cars = carService.findAll(field,word,pageable);
		Long count = carService.count(field,word);
		model.addAttribute("cars", cars);
		model.addAttribute("count", count);
		return "listCar";
		
	}
}
