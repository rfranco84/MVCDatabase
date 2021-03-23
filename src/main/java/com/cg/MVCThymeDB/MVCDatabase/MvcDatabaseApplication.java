/**
 * 
 * MVC Database application showing how to work with Spring Boot, Thymeleaf, and MySQL
 * 
 */

package com.cg.MVCThymeDB.MVCDatabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Annotation includes auto-configuration, scans for components, identifies app as a Spring Boot application.
@SpringBootApplication
public class MvcDatabaseApplication {

	// Entry Point
	public static void main(String[] args) {
		SpringApplication.run(MvcDatabaseApplication.class, args);
	}

}
