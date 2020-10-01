package com.capgemini.healthcaremanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.capgemini.healthcaremanagementsystem.entity.Appointment;

public interface AppointmentDao extends JpaRepository<Appointment, Long> {

	//@Query("FROM Appointment WHERE centerId=:centerId AND status=false")
	
	//public List<Appointment> findUnApprovedAppointments(@Param("centerId") String centerId);

	//public List<Appointment findAppointmentByCustomerId(Long customerId);
}
