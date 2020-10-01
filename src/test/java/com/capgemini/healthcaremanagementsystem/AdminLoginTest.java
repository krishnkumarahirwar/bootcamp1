package com.capgemini.healthcaremanagementsystem;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.healthcaremanagementsystem.dao.AdminDao;
import com.capgemini.healthcaremanagementsystem.entity.Admin;
import com.capgemini.healthcaremanagementsystem.serviceimpl.AdminServiceImpl;

@SpringBootTest
public class AdminLoginTest {
	
	@Mock
	private AdminDao dao;
	
	@InjectMocks
	private AdminServiceImpl service;
	
	
	@Test
	public void testAdminLogin() {
		
	}

}
