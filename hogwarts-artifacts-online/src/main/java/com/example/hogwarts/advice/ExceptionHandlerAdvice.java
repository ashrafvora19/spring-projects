package com.example.hogwarts.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.hogwarts.dtos.Result;
import com.example.hogwarts.exceptions.ResourceNotFoundException;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

	@ExceptionHandler(value = {ResourceNotFoundException.class})
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public Result handleResourceNotFoundException(ResourceNotFoundException e) {
		return new Result(false, HttpStatus.NOT_FOUND.value(), e.getMessage(), null);
	}
}
