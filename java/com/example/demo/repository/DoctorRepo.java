package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Doctors;
@Repository
public interface  DoctorRepo extends JpaRepository<Doctors,Long> {
	
}
