package com.cognizant.eurekadiscoveryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekadiscoveryserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekadiscoveryserviceApplication.class, args);
	}

}
