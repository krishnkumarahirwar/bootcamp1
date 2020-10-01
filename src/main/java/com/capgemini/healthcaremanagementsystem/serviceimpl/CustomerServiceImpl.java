package com.capgemini.healthcaremanagementsystem.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.healthcaremanagementsystem.dao.AppointmentDao;
import com.capgemini.healthcaremanagementsystem.dao.CustomerDao;
import com.capgemini.healthcaremanagementsystem.dao.TestDao;
import com.capgemini.healthcaremanagementsystem.entity.Appointment;
import com.capgemini.healthcaremanagementsystem.entity.Customer;
import com.capgemini.healthcaremanagementsystem.entity.Test;
import com.capgemini.healthcaremanagementsystem.exception.AdminNotFoundException;
import com.capgemini.healthcaremanagementsystem.exception.AppointmentNotFoundException;
import com.capgemini.healthcaremanagementsystem.exception.ContactNumberAlreadyExistException;
import com.capgemini.healthcaremanagementsystem.exception.CustomerNameAlreadyExistException;
import com.capgemini.healthcaremanagementsystem.exception.CustomerNotFoundException;
import com.capgemini.healthcaremanagementsystem.exception.EmailAlreadyExistException;
import com.capgemini.healthcaremanagementsystem.exception.TestNotFoundException;
import com.capgemini.healthcaremanagementsystem.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private TestDao testDao;

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private AppointmentDao appointmentDao;

	@Override
	public Customer registerCustomer(Customer customer)
			throws CustomerNameAlreadyExistException, ContactNumberAlreadyExistException, EmailAlreadyExistException {

		if (customerDao.findCustomerByCustomerName(customer.getCustomerName()) != null)
			throw new CustomerNameAlreadyExistException(
					"customer with Name " + customer.getCustomerName() + " is Already Exist");

		if (customerDao.findCustomerByCustomerPhoneNumber(customer.getCustomerPhoneNumber()) != null)
			throw new ContactNumberAlreadyExistException(
					"customer with ContactNumber " + customer.getCustomerPhoneNumber() + " is Already Exist");

		if (customerDao.findCustomerByCustomerEmail(customer.getCustomerEmail()) != null)
			throw new EmailAlreadyExistException(
					"customer with Email " + customer.getCustomerEmail() + " is Already Exist");

		customer = customerDao.save(customer);
		return customer;
	}

	@Override
	public Customer customerLogin(String customerName, String customerPassword) throws CustomerNotFoundException {
		Customer customer = customerDao.findCustomerByCustomerName(customerName);
		if ((customer != null && customer.getCustomerPassword().equals(customerPassword)
				&& customer.getCustomerName().equals(customerName)))
			return customer;
		throw new AdminNotFoundException(
				"customer with CustomerName [" + customerName + "] and password [" + customerPassword + "] not found");
	}

	@Override
	public List<Test> findAllTests() {
		return testDao.findAll();
	}

	@Override
	public Test findTestById(Long testId) throws TestNotFoundException {
		Optional<Test> optional = testDao.findById(testId);
		if (optional.isPresent()) {
			Test test = optional.get();
			return test;

		}
		throw new TestNotFoundException("Test Id not found!!");
	}

	@Override
	public Appointment makeAppointment(Appointment appointment) {
		Appointment app = appointmentDao.save(appointment);
		return app;
	}

	@Override
	public Appointment getAppointment(Long appointmentId) {
		if (!appointmentDao.existsById(appointmentId)) {
			throw new AppointmentNotFoundException("Appointment with id " + appointmentId + "not found");
		}
		return appointmentDao.getOne(appointmentId);
	}

	@Override
	public List<Appointment> getAllAppointments() {
		if (appointmentDao.findAll().isEmpty()) {
			throw new AppointmentNotFoundException("Appointment list is empty");
		}
		List<Appointment> allAppointments = appointmentDao.findAll();
		return allAppointments;
	}

}
