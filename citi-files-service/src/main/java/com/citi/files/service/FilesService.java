/**
 * copyright
 */
package com.citi.files.service;

import org.springframework.web.multipart.MultipartFile;

import com.citi.files.dto.APIResponse;

public interface FilesService {

	APIResponse fileProcess(MultipartFile file) throws Exception;

	APIResponse fileProcess2(MultipartFile file) throws Exception;

}
