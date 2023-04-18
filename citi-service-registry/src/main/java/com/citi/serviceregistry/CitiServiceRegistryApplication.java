/**
 * 
 */
package com.citi.serviceregistry;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CitiServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(CitiServiceRegistryApplication.class, args);
	}

}
