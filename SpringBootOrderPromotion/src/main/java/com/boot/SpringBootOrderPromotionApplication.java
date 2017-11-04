package com.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.boot.data")
public class SpringBootOrderPromotionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootOrderPromotionApplication.class, args);
	}
}
