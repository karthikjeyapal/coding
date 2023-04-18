/**
 * 
 */
package com.citi.apigateway;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CitiApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(CitiApiGatewayApplication.class, args);
	}

}
