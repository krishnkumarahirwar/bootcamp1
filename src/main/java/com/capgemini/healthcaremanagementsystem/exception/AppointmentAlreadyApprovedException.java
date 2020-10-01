package com.capgemini.healthcaremanagementsystem.exception;

public class AppointmentAlreadyApprovedException extends  RuntimeException {

	public AppointmentAlreadyApprovedException(String message)
	{
		super(message);
	}
}