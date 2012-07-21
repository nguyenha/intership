package com.home.qh.config;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = { "com.home.qh", "com.home.qh.jpa" })
@ImportResource("classpath:*springDataConfig.xml")
@Import({ PersistenceConfig.class, SecurityConfig.class })
public class RootConfig {}