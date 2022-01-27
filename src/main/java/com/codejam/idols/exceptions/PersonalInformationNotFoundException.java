package com.codejam.idols.exceptions;

public class PersonalInformationNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PersonalInformationNotFoundException() {
		super();
	}

	public PersonalInformationNotFoundException(String message) {
		super(message);
	}

}
