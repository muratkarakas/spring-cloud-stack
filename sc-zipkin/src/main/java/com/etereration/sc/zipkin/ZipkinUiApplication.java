package com.etereration.sc.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class ZipkinUiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinUiApplication.class, args);
	}


}
