package com.codejam.idols.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.codejam.idols.custom.error.ErrorTypes;
import com.codejam.idols.exceptions.PersonalInformationNotFoundException;
import com.codejam.idols.exceptions.RevenueNotFoundException;
import com.codejam.idols.exceptions.ScheduleNotFoundException;

@RestControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorTypes> handleUnknownExceptions(Exception e) {
		return new ResponseEntity<ErrorTypes>(
				new ErrorTypes(new Date().toString(), "UNKNOWN EXCEPTION (500)", e.getMessage()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(PersonalInformationNotFoundException.class)
	public ResponseEntity<ErrorTypes> handlePersonalInformationNotFoundException(
			PersonalInformationNotFoundException pie) {
		return new ResponseEntity<ErrorTypes>(
				new ErrorTypes(new Date().toString(), "PERSONAL INFORMATION", pie.getMessage()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ScheduleNotFoundException.class)
	public ResponseEntity<ErrorTypes> handleScheduleNotFoundException(ScheduleNotFoundException sne) {
		return new ResponseEntity<ErrorTypes>(new ErrorTypes(new Date().toString(), "SCHEDULE", sne.getMessage()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(RevenueNotFoundException.class)
	public ResponseEntity<ErrorTypes> handleRevenueNotFoundException(RevenueNotFoundException rne) {
		return new ResponseEntity<ErrorTypes>(new ErrorTypes(new Date().toString(), "REVENUE", rne.getMessage()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
