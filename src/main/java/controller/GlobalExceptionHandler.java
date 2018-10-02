package controller;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(value = NullPointerException.class)
	public String handleNullPointerException(Exception e) {
		
		System.out.println("Null Pointer Exception Occured: "+e);
		return "NullPointerException";
	}
	
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = IOException.class)
	public String handleIOException(Exception e) {
		
		System.out.println("IO Exception Occured: "+e);
		return "IOException";
	}
	
	
}
