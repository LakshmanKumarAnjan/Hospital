package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Patient;
import com.example.demo.repository.PatientRepo;

@Service
public class PatientService {

	@Autowired
	private PatientRepo patientRepo;
	public String upsert(Patient patient) {
		patientRepo.save(patient);
		return "Success";
		}
	
	public Optional<Patient> findpatientById(Long Id) {
		return patientRepo.findById(Id);
	}
}
