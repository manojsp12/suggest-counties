package com.example.counties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 
 * Spring boot application used for type-ahead suggestions for US counties.
 * 
 * @author Manoj SP
 *
 */
@SpringBootApplication
@EnableCaching
public class SuggestCountiesApplication {

	/**
	 * `SpringApplication.run(SuggestCountiesApplication.class, args);`
	 * 
	 * This function is the entry point for the application. It tells Spring to run
	 * the application
	 * 
	 * @param args arguments as input
	 */
	public static void main(String[] args) {
		SpringApplication.run(SuggestCountiesApplication.class, args);
	}

}
