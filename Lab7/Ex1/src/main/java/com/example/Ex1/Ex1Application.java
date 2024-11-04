package com.example.Ex1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ex1Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Ex1Application.class, "args");
	}
	@Override
	public void run(String[] args) throws Exception {
		System.out.println("Welcome to Java tech World");
	}
}
