package com.spring.boot.app.soap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootSoapApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootSoapApplication.class);

	public static void main(String[] args) {
		LOGGER.info("Start SpringBootSoapApplication ...  ");
		SpringApplication.run(SpringBootSoapApplication.class, args);
		LOGGER.info("App Iniciada SpringBootSoapApplication ...  ");
	}

}
