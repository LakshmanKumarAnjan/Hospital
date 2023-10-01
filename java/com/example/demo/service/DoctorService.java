package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Doctors;
import com.example.demo.repository.DoctorRepo;



@Service
public class DoctorService {
		
	@Autowired
	private DoctorRepo doctorRepo;
	public String upsert(Doctors doctor) {
		doctorRepo.save(doctor);
		return "Success";
		}
	
	public Optional<Doctors> findDoctorById(Long Id) {
		return doctorRepo.findById(Id);
	}

	
}
