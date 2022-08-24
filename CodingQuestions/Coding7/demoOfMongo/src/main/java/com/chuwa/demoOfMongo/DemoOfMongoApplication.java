package com.chuwa.demoOfMongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class DemoOfMongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoOfMongoApplication.class, args);
	}

}
