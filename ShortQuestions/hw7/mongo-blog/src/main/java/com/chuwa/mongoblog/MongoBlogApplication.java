package com.chuwa.mongoblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MongoBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoBlogApplication.class, args);
	}

}
