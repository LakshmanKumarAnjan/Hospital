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
import com.example.demo.entity.Location;
import com.example.demo.service.DoctorService;
import com.example.demo.service.LocationServices;

@RestController
@RequestMapping("/api/locations")
public class LocationController {

	@Autowired
	private LocationServices locationService;
	
	@PostMapping("/location")
	public ResponseEntity<String> createLocation(@RequestBody Location location){
		String status=locationService.upsert(location);
		return new ResponseEntity<>(status,HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Location> getlocationById(@PathVariable Long id){
		
		Optional<Location> location = locationService.findLocationById(id);
		if(location.isPresent()) {
			return ResponseEntity.ok(location.get());
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
