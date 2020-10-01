package com.capgemini.healthcaremanagementsystem.service;

import java.util.List;

import com.capgemini.healthcaremanagementsystem.entity.Appointment;
import com.capgemini.healthcaremanagementsystem.entity.Customer;
import com.capgemini.healthcaremanagementsystem.entity.Test;
import com.capgemini.healthcaremanagementsystem.exception.TestNotFoundException;

public interface CustomerService {

	public Customer registerCustomer(Customer customer);

	public Test findTestById(Long testId) throws TestNotFoundException;

	public List<Test> findAllTests();

	public Customer customerLogin(String customerName, String customerPassword);

	public Appointment makeAppointment(Appointment appointment);

	public Appointment getAppointment(Long appointmentId);

	public List<Appointment> getAllAppointments();

}
