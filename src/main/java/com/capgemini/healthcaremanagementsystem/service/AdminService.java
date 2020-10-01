package com.capgemini.healthcaremanagementsystem.service;

import java.util.List;

import com.capgemini.healthcaremanagementsystem.entity.Admin;
import com.capgemini.healthcaremanagementsystem.entity.Appointment;
import com.capgemini.healthcaremanagementsystem.entity.DiagnosticCenter;
import com.capgemini.healthcaremanagementsystem.entity.Test;
import com.capgemini.healthcaremanagementsystem.exception.DiagnosticCenterNotExistsException;
import com.capgemini.healthcaremanagementsystem.exception.TestIdDoesNotExistException;
import com.capgemini.healthcaremanagementsystem.exception.TestNotFoundException;

public interface AdminService {
	
	Admin adminLogin(String adminName, String adminPassword);

	public Test addTest(Test test) throws DiagnosticCenterNotExistsException;

	boolean deleteTestById(long testId) throws TestNotFoundException;

	public Test findTestById(long testId) throws TestIdDoesNotExistException;

	public Test updateTest(Test test) throws TestNotFoundException, DiagnosticCenterNotExistsException;

	public DiagnosticCenter addDiagnosticCenter(DiagnosticCenter center);

	public boolean removeDiagnosticCenter(long centerId);

	public DiagnosticCenter findDiagnosticCenterById(long centerId);

	public List<DiagnosticCenter> viewAllDiagnosticCenter();

	public Appointment approveAppointment(Appointment appointment, String status);

	

}
