package com.anvil.rakoi.anvil;

import com.anvil.rakoi.anvil.config.DataTablesConfiguration;
import com.anvil.rakoi.anvil.config.DefaultJpaConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.datatables.repository.DataTablesRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

//@SpringBootApplication(exclude = {DefaultJpaConfiguration.class })
public class AnvilApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(AnvilApplication.class, args);
		System.out.println("HELLO SPRING BOOTY");
	}

}
