package com.example.restful_web_service.exception;

import java.sql.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.example.restful_web_service.exception.ExceptionResponse;

@ControllerAdvice//sharable to all controllers present
@RestController
public class CustomisedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	/*
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex,WebRequest request){
		ExceptionResponse er= ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity(er,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleUserNotFoundExceptions(Exception ex,WebRequest request){
		ExceptionResponse er= ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity(er,HttpStatus.NOT_FOUND);
	}
	*/

}
