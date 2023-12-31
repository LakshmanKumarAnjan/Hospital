package com.example.demo.entity;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Doctors {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String name;
    private int max_patients;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMax_patients() {
		return max_patients;
	}
	public void setMax_patients(int max_patients) {
		this.max_patients = max_patients;
	}
    
}
