package com.anvil.rakoi.anvil.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.anvil.rakoi.anvil.repos.DTRepos")
public class DefaultJpaConfiguration {}

