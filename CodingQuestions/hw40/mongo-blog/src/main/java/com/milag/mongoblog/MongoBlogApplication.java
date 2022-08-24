package com.milag.mongoblog;

import com.milag.mongoblog.dao.PostRepository;
import com.milag.mongoblog.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MongoBlogApplication implements CommandLineRunner{

	@Autowired
	PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {

	}

	public static void main(String[] args) {
		SpringApplication.run(MongoBlogApplication.class, args);
	}


}
