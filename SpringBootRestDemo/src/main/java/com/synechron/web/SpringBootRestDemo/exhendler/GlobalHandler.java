package com.synechron.web.SpringBootRestDemo.exhendler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.persistence.EntityNotFoundException;

@ControllerAdvice
//@Component
public class GlobalHandler {

	public GlobalHandler() {
		System.out.println("global handler");
	}
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex){
		System.out.println("entity not found");
		Map<String, Object> map = new  HashMap<>();
		map.put("message", ex.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleEntityNotFound(Exception ex){
		System.out.println("general exception");
		Map<String, Object> map = new  HashMap<>();
		map.put("message", ex.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
	}
}
