package com.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.json.GsonBuilderUtils;

@SpringBootApplication
public class SpringDemoTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoTestApplication.class, args);
		System.out.println("Spring Boot Test application starts");
	}

}
