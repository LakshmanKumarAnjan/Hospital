package com.example.demo.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Appointments;
import com.example.demo.entity.Doctors;
import com.example.demo.entity.Location;
import com.example.demo.entity.Patient;
import com.example.demo.repository.AppointmentRepo;


@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepo appointmentRepo;

	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private LocationServices locationService;
	
	@Autowired
	private PatientService patientService;
	
	public String upsert(Appointments appointment) {
		
		Optional<Doctors> doctor = doctorService.findDoctorById(appointment.getDoctorid()); 
		
		if(doctor.isPresent()==false) {
			return "Inavlid Doctor Id";
		}
		
		Optional<Location> location = locationService.findLocationById(appointment.getLocation_id()); 
		
		if(location.isPresent()==false) {
			return "Inavlid Location Id";
		}
		
		Optional<Patient> patient = patientService.findpatientById(appointment.getPatientid()); 
		
		if(patient.isPresent()==false) {
			return "Inavlid Patient Id";
		}
		
		LocalDateTime appointmentTime = appointment.getAppointmenttime(); 
		if (appointmentTime.getDayOfWeek() == DayOfWeek.SUNDAY) {
			return "Doctor is not available on Sunday"; 
			}
			LocalDate appointmentDate = appointmentTime.toLocalDate();
			int maxAppointments = doctor.get().getMax_patients() ;
			long existingAppointments = appointmentRepo.countByDoctorAndAppointmentTimeBetween(  appointmentDate.atStartOfDay(), appointmentDate.atTime(LocalTime.MAX),doctor.get().getId() ); 
			
			
			if (existingAppointments >= maxAppointments) { 
				return "Doctor has reached the maximum appointments for that date"; } 
		
		appointmentRepo.save(appointment);
		return "Success";
		}
	
	public Optional<Appointments> findAppointmentById(Long Id) {
		return appointmentRepo.findById(Id);
	}
}
