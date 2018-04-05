package com.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class StudentApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}
	
	 /**
     * Used when run as WAR
     */
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(StudentApplication.class);
    }
}


