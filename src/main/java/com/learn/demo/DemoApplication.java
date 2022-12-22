package com.learn.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learn.demo.Dao.ProductRepository;
import com.learn.demo.model.Product;

import org.springframework.context.ApplicationContext;
//import ch.qos.logback.core.Context;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	   //ProductRepository userRepository = Context.getBean(ProductRepository.class);
	}

}
