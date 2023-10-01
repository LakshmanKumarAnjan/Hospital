package com.example.demo.repository;

import com.example.demo.entity.*;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepo extends JpaRepository <Appointments,Long>{

	//long countByDoctorAndAppointmentTimeBetween(Optional<Doctors> doctor, LocalDateTime atStartOfDay,
			//LocalDateTime atTime);

	//@Query("FROM Appointments a WHERE a.appointmentTime <= :endDate AND a.appointmentTime >= :stDate AND a.doctorId = :did")
    //public List<Appointments> countByDoctorAndAppointmentTimeBetween( @Param(value="stDate") LocalDateTime localDateTime , @Param(value="endDate") LocalDateTime localDateTime2,@Param(value="did") long did);
	
	@Query("SELECT count (*) FROM Appointments a WHERE a.appointmenttime <= :endDate AND a.appointmenttime >= :stDate AND a.doctorid = :did")
	public long countByDoctorAndAppointmentTimeBetween(@Param("stDate") LocalDateTime stDate, @Param("endDate") LocalDateTime endDate, @Param("did") Long doctorId);

	
}
