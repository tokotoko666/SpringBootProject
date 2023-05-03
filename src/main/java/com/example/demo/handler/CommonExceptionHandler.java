package com.example.demo.handler;

import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.entity.CommonResponse;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class CommonExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		ServletWebRequest req = (ServletWebRequest) request;
		log.warn("resource not found. {}", req.getRequest().getRequestURI());
		return new ResponseEntity<Object>(
				CommonResponse.builder().status("failure").message("resource not found.").build(),
				HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<CommonResponse> handleValidationError(ConstraintViolationException e) {

		String validateionErrorMessage = e.getConstraintViolations().stream()
				.map(cv -> cv.getPropertyPath().toString() + ":" + cv.getMessage()).collect(Collectors.joining(", "));

		log.info("Bad Request. {}", validateionErrorMessage);

		return new ResponseEntity<>(CommonResponse.builder().status("failure").message(validateionErrorMessage).build(),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler
	public ResponseEntity<CommonResponse> handleException(Exception e) {
		log.error("Request Failed", e);
		return new ResponseEntity<>(CommonResponse.builder().status("failure").message("error has occurred.").build(),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
