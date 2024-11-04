package com.example.Ex5;

import com.example.Ex5.Controller.StudentServiceImpl;
import com.example.Ex5.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ex5Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Ex5Application.class, args);
	}

	@Autowired
	StudentServiceImpl studentServiceImpl;

	public void run(String... args) {
//		Student student1 = new Student(2L, "Alice", 33, "alicu@gmail.com", 9);
//		Student student2 = new Student(3L, "Bob", 32, "boba@gmail.com", 8.5);
//		Student student3 = new Student(3L, "Bobbery", 15, "bobaaa@gmail.com", 7.5);
//		Student student4 = new Student(4L, "Charlie", 24, "charlie@gmail.com", 7);
//		Student student5 = new Student(5L, "David", 21, "david@gmail.com", 6.5);
//
//		studentServiceImpl.save(student1);
//		studentServiceImpl.save(student2);
//		studentServiceImpl.save(student3);
//		studentServiceImpl.save(student4);
//		studentServiceImpl.save(student5);

//		System.out.println("Data after insert students" + studentServiceImpl.findAll());
//		studentServiceImpl.delete(2L);
//		System.out.println("Data after deleting student:" + studentServiceImpl.findAll());
//		studentServiceImpl.update(1L, student3);
//		System.out.println("Data after updated: " + studentServiceImpl.findAll());

		System.out.println("Students greater than 23: " + studentServiceImpl.getStudentAgeGreaterOrEqual(23));
		System.out.println("Students has name containing 'OB'" + studentServiceImpl.getStudentsNameContainingWord("OB"));
		System.out.println("Students has ielts score is 8.5" + studentServiceImpl.getStudentsIeltsScoreEqual(8.5));
	}
}
