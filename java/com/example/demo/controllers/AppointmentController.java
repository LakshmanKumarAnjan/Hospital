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

import com.example.demo.entity.Appointments;
import com.example.demo.entity.Doctors;
import com.example.demo.service.AppointmentService;
import com.example.demo.service.DoctorService;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;
	
	@PostMapping("/appointment")
	public ResponseEntity<String> createAppointment(@RequestBody Appointments appointment){
		String status=appointmentService.upsert(appointment);
		return new ResponseEntity<>(status,HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Appointments> getAppointmentById(@PathVariable Long id){
		
		Optional<Appointments> appointment = appointmentService.findAppointmentById(id);
		if(appointment.isPresent()) {
			return ResponseEntity.ok(appointment.get());
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
