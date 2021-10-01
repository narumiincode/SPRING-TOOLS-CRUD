package br.org.generation.minhalojagame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"minhalojagame.model"})
@SpringBootApplication
public class minhalojagameApplication {

	public static void main(String[] args) {
		SpringApplication.run(minhalojagameApplication.class, args);
	}

}
