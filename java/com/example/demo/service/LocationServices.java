package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Location;

import com.example.demo.repository.LocationRepo;


@Service
public class LocationServices {

	@Autowired
	private LocationRepo locationRepo;
	public String upsert(Location location) {
		locationRepo.save(location);
		return "Success";
		}
	
	public Optional<Location> findLocationById(Long Id) {
		return locationRepo.findById(Id);
	}
}
