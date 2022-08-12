package com.example.parkingtest.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.parkingtest.model.Car;
import com.example.parkingtest.repository.CarRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CarService {

	private final CarRepository carRepository;
	
	@Transactional
	public void save(Car car) {
		carRepository.save(car);		
	}
	@Transactional
	public void parkingtypeset(Car car) {
		Car c= carRepository.findById(car.getCarNum()).get();
		if(c.getFee()==300000) {
			c.setParkingType("월주차");
		}
		else if(c.getFee()==100000) {
			c.setParkingType("주주차");
		}
		else if(c.getFee()==20000) {
			c.setParkingType("일주차");
		}
		else{
			c.setParkingType("자유주차");
		} 
	}
	
	public Page<Car> findAll(String field,String word,Pageable pageable){
		if(field.equals("carNum"))
			return carRepository.findByCarNumContaining(word,pageable);
		if(field.equals("parkingType"))
			return carRepository.findByParkingTypeContaining(word,pageable);
		
		return carRepository.findAll(pageable);
	}
	
	public Long count(String field,String word) {
		if(field.equals("carNum"))
			return carRepository.cntCarNumSearch(word);
		if(field.equals("parkingType"))
			return carRepository.cntParkingTypeSearch(word);
		return carRepository.count();
	}
	

	

}
