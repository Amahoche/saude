package com.projecto.saude.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadResourceException extends RuntimeException {

	public BadResourceException(String message) {
		super(message);
	}
}
