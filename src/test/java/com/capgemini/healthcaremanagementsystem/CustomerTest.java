package com.capgemini.healthcaremanagementsystem;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import com.capgemini.healthcaremanagementsystem.dao.CustomerDao;
import com.capgemini.healthcaremanagementsystem.entity.Customer;
import com.capgemini.healthcaremanagementsystem.serviceimpl.CustomerServiceImpl;

@SpringBootTest
public class CustomerTest {


@Mock
private  CustomerDao dao;
@InjectMocks
private CustomerServiceImpl service;

Customer customer = new Customer();

@Test
public void customerRegister()
{

customer.setCustomerId(2);
customer.setCustomerPassword("abcd");
customer.setCustomerName("priya");
customer.setCustomerEmail("priy@gmail.com");
customer.setGender("Female");

service.registerCustomer(customer);
Mockito.verify(dao, Mockito.times(1)).save(customer);
   }
       

}
