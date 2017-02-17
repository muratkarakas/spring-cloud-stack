package com.etereration.sc.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SCEurekaServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(SCEurekaServerApplication.class, args);
	}

}