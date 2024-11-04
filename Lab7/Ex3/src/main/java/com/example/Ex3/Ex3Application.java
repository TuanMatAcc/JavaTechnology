package com.example.Ex3;

import com.example.Ex3.Controller.StudentServiceImpl;
import com.example.Ex3.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ex3Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Ex3Application.class, args);
	}

	@Autowired
	StudentServiceImpl studentServiceImpl;

	public void run(String... args) {
		Student student1 = new Student(2L, "Alice", 23, "alicu@gmail.com", 9);
		Student student2 = new Student(3L, "Bob", 22, "boba@gmail.com", 8.5);
		Student student3 = new Student(3L, "Bobbery", 25, "bobaaa@gmail.com", 7.5);
		studentServiceImpl.save(student1);
		studentServiceImpl.save(student2);
		studentServiceImpl.save(student3);
		System.out.println("Data after insert students" + studentServiceImpl.findAll());
		studentServiceImpl.delete(2L);
		System.out.println("Data after deleting student:" + studentServiceImpl.findAll());
		studentServiceImpl.update(1L, student3);
		System.out.println("Data after updated: " + studentServiceImpl.findAll());
	}
}
