package com.anvil.rakoi.anvil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.datatables.repository.DataTablesRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.anvil.rakoi.anvil.repos")

public class AnvilApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(AnvilApplication.class, args);
		System.out.println("HELLO SPRING BOOTY");
	}

}
