package com.anvil.rakoi.anvil;

import com.anvil.rakoi.anvil.services.SmsSender;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.datatables.repository.DataTablesRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.anvil.rakoi.anvil.repos")

public class AnvilApplication {



	public static void main(String[] args) {
		SpringApplication.run(AnvilApplication.class, args);
		System.out.println("HELLO SPRING BOOTY");


	}

	@Bean
	public ObjectMapper objectMapper(){
		return new ObjectMapper();
	}
	@Bean
	public OkHttpClient okHttpClient(){
		return new OkHttpClient();
	}

	@Bean
	public Gson gson(){
		return new Gson();
	};

}
