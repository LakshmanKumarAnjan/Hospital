package com.example.demo.entity;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.time.LocalDateTime;
@Entity
public class Appointments {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long patientid;
    private Long doctorid;
    private LocalDateTime appointmenttime;
	private Long location_id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getPatientid() {
		return patientid;
	}
	public void setPatientid(Long patientid) {
		this.patientid = patientid;
	}
	public Long getDoctorid() {
		return doctorid;
	}
	public void setDoctorid(Long doctorid) {
		this.doctorid = doctorid;
	}
	public LocalDateTime getAppointmenttime() {
		return appointmenttime;
	}
	public void setAppointmenttime(LocalDateTime appointmenttime) {
		this.appointmenttime = appointmenttime;
	}
	public Long getLocation_id() {
		return location_id;
	}
	public void setLocation_id(Long location_id) {
		this.location_id = location_id;
	}
	public Appointments(Long id, Long patientid, Long doctorid, LocalDateTime appointmenttime, Long location_id) {
		super();
		this.id = id;
		this.patientid = patientid;
		this.doctorid = doctorid;
		this.appointmenttime = appointmenttime;
		this.location_id = location_id;
	}
	public Appointments() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
    
}
