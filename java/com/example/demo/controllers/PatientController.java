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
import com.example.demo.entity.Patient;
import com.example.demo.service.DoctorService;
import com.example.demo.service.PatientService;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

	@Autowired
	private PatientService patientService;
	
	@PostMapping("/patient")
	public ResponseEntity<String> createPatient(@RequestBody Patient patient){
		String status=patientService.upsert(patient);
		return new ResponseEntity<>(status,HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable Long id){
		
		Optional<Patient> patient = patientService.findpatientById(id);
		if(patient.isPresent()) {
			return ResponseEntity.ok(patient.get());
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
