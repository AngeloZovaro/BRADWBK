package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootTest
@RestController

class DemoApplicationTests {
	//injeção de dependencia

	@Autowired
	HelloGenerator hello;

	@GetMapping("/hello")
	String getTexto(){
		return hello.generateHello(); //retorna função
	}

	public static void main(String[] args) {
	SpringApplication.run(DemoApplication.class, args);
	}


}
