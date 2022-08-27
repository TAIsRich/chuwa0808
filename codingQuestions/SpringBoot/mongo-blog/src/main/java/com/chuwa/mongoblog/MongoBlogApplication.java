package com.chuwa.mongoblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class MongoBlogApplication {

	public static void main(String[] args) {

		SpringApplication.run(MongoBlogApplication.class, args);
	}

}
