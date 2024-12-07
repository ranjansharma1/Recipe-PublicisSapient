package com.recipes.publicisSapient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //@Configuration + @EnableAutoConfiguration + @ComponentScan 
public class RecipeApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(RecipeApplication.class, args);
	}

}
