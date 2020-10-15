package com.wellsfargo.interviewtracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.wellsfargo.interviewtracker.exception.model.ExceptionResponse;

@RestControllerAdvice
public class GlobalException {

	// Exception Handler Method
		@ExceptionHandler(NotFoundException.class)
		public ResponseEntity<ExceptionResponse> handler(NotFoundException ex) {
			ExceptionResponse exResponse =
					new ExceptionResponse(ex.getMessage(), System.currentTimeMillis(), HttpStatus.NOT_FOUND.value());
			ResponseEntity<ExceptionResponse> response = 
					new ResponseEntity<ExceptionResponse>(exResponse, HttpStatus.NOT_FOUND);
			return response;
		}
		
		// Exception Handler Method
		@ExceptionHandler(Exception.class)
		public ResponseEntity<ExceptionResponse> handler(Exception ex) {
			ExceptionResponse exResponse =
					new ExceptionResponse(ex.getMessage(), System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value());
			ResponseEntity<ExceptionResponse> response = 
					new ResponseEntity<ExceptionResponse>(exResponse, HttpStatus.BAD_REQUEST);
			return response;
		}
}
