package com.example.androidPhone01.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.androidPhone01.model.Phone;
import com.example.androidPhone01.repository.PhoneRepository;

@Service
public class PhoneService {
	
	@Autowired
	private PhoneRepository pRepository;

	public Phone insert(Phone phone) {
		return pRepository.save(phone);
	}

	public List<Phone> list() {
 		return pRepository.findAll();
	}

	public void delete(Long num) {
		pRepository.deleteById(num);
	}

	@Transactional
	public Phone update(Long id, Phone phone) {
		Phone p = pRepository.findById(id).get();
		p.setName(phone.getName());
		p.setTel(phone.getTel());
		return p;
	}

}
