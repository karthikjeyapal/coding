package com.citi.files.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.citi.files.dto.APIResponse;

public class TestRestCall {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.MULTIPART_FORM_DATA);

			MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();

			FileSystemResource fs = new FileSystemResource("C:\\CITI\\IntlMarket_1m.csv");

			body.add("file", fs);

			HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

			String serverUrl = "http://localhost:9191/api/files/fileProcess2";

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<APIResponse> response = restTemplate.postForEntity(serverUrl, requestEntity,
					APIResponse.class);

			System.out.println("Respose Body:" + response.getBody().getMessage());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
