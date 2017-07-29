package io.dailydev.r3vl.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class R3vlApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(R3vlApiApplication.class, args);
		System.out.println("R3VL API is running!");
	}
}
