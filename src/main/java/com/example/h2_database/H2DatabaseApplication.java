package com.example.h2_database;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class H2DatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(H2DatabaseApplication.class, args);
	}

}
