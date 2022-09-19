package com.chuwa.redbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 程序入口：写好entity package里的Post class, run这个RedbookApplication class, 右侧MySQL的redbook database中就会出现posts table
@SpringBootApplication
public class RedbookApplication {
	public static void main(String[] args) {
		SpringApplication.run(RedbookApplication.class, args);
	}
}
