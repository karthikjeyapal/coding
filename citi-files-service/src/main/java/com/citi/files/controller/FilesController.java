/**
 * copyright
 */
package com.citi.files.controller;

import com.citi.files.dto.APIResponse;
import com.citi.files.service.FilesService;
import com.citi.files.utils.FilesUtils;

import lombok.AllArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/files")
@AllArgsConstructor
public class FilesController {

	private static final Logger LOGGER = LoggerFactory.getLogger(FilesController.class);

	private FilesService fileService;

	@GetMapping("/getFiles")
	public ResponseEntity<APIResponse> getFiles() {
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * 
	 * @param file
	 * @return
	 */
	@PostMapping("/fileProcess")
	public ResponseEntity<APIResponse> fileProcess(@RequestParam("file") MultipartFile file) {

		LOGGER.info("inside the fileprocess method");
		String message = "";
		APIResponse response = new APIResponse();

		if (FilesUtils.hasCSVFormat(file)) {

			try {

				response = fileService.fileProcess(file);
				message = "Processed the file successfully: " + file.getOriginalFilename();
				response.setMessage(message);
				return ResponseEntity.status(HttpStatus.OK).body(response);
			} catch (Exception e) {
				message = "Could not process the file: " + file.getOriginalFilename() + "!";
				response.setMessage(message);
				return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(response);
			}

		} else {

			message = "Could not process the file: " + file.getOriginalFilename() + "!";
			response.setMessage(message);
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(response);

		}

	}

	/**
	 * 
	 * @param file
	 * @return
	 */
	@PostMapping("/fileProcess2")
	public ResponseEntity<APIResponse> fileProcess2(@RequestParam("file") MultipartFile file) {
		LOGGER.info("inside the fileprocess2 method");
		String message = "";
		APIResponse response = new APIResponse();

		if (FilesUtils.hasCSVFormat(file)) {

			try {

				response = fileService.fileProcess2(file);
				message = "Processed the file successfully: " + file.getOriginalFilename();
				response.setMessage(message);
				return ResponseEntity.status(HttpStatus.OK).body(response);
			} catch (Exception e) {
				message = "Could not process the file: " + file.getOriginalFilename() + "!";
				response.setMessage(message);
				return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(response);
			}

		} else {

			message = "Could not process the file: " + file.getOriginalFilename() + "!";
			response.setMessage(message);
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(response);

		}

	}

}
