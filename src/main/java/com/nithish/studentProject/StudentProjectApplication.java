package com.nithish.studentProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//`@ComponentScan(basePackages={"com.nithish.studentProject"})
public class StudentProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentProjectApplication.class, args);
	}

}
