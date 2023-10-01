package com.example.demo.controllers;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Doctors;
import com.example.demo.service.DoctorService;




@RestController
@RequestMapping("/api/doctors")
public class DoctorsController {
	
	@Autowired
	private DoctorService doctorService;
	
	@PostMapping("/doctor")
	public ResponseEntity<String> createDoctor(@RequestBody Doctors doctor){
		String status=doctorService.upsert(doctor);
		return new ResponseEntity<>(status,HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Doctors> getDoctorById(@PathVariable Long id){
		
		Optional<Doctors> doctor = doctorService.findDoctorById(id);
		if(doctor.isPresent()) {
			return ResponseEntity.ok(doctor.get());
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
