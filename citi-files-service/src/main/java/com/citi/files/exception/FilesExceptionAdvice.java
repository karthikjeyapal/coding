/**
 * copyright
 */
package com.citi.files.exception;

import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.citi.files.dto.APIResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class FilesExceptionAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public ResponseEntity<APIResponse> handleMaxSizeException(MaxUploadSizeExceededException exc) {
		APIResponse response=new APIResponse();
		response.setMessage("File too large!");
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(response);
	}
}
