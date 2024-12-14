package com.example.Lab10;

import com.example.Lab10.Model.Order;
import com.example.Lab10.Model.Product;
import com.example.Lab10.Service.OrderService;
import com.example.Lab10.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lab10Application implements CommandLineRunner {
	@Autowired
	private OrderService orderService;
	@Autowired
	private ProductService productService;
	public static void main(String[] args) {
		SpringApplication.run(Lab10Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
	}
}
