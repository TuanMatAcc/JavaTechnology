package com.example.Ex2;

import com.example.Ex2.Service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ex2Application implements CommandLineRunner {
	@Autowired
	EmployeeServiceImpl employeeServiceImpl;
	public static void main(String[] args) {

		SpringApplication.run(Ex2Application.class, args);

	}

	public void run(String... args) {
//		Employee employee1 = new Employee(1, "Thomas Hardy", "thomashardy@mail.com", "89 Chiaroscuro Rd, Portland, USA", "(171) 555-2222");
//		Employee employee2 = new Employee(2, "Dominique Perrier", "dominiqueperrier@mail.com", "Obere Str. 57, Berlin, Germany", "(313) 555-5735");
//		Employee employee3 = new Employee(3, "Maria Anders", "mariaanders@mail.com", "25, rue Lauriston, Paris, France", "(503) 555-9931");
//		Employee employee4 = new Employee(4, "Fran Wilson", "franwilson@mail.com", "C/ Araquil, 67, Madrid, Spain", "(204) 619-5731");
//		Employee employee5 = new Employee(5, "Martin Blank", "martinblank@mail.com", "Via Monte Bianco 34, Turin, Italy", "(480) 631-2097");
//
//		employeeServiceImpl.save(employee1);
//		employeeServiceImpl.save(employee2);
//		employeeServiceImpl.save(employee3);
//		employeeServiceImpl.save(employee4);
//		employeeServiceImpl.save(employee5);
	}

}
