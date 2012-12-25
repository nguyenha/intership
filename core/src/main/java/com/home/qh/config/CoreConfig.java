package com.home.qh.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan(basePackages = { "com.home.qh", "com.home.qh.jpa" })
@ImportResource("classpath:*springDataConfig.xml")
//@ContextConfiguration("classpath:*springDataConfig.xml")
@Import({ PersistenceConfig.class })
public class CoreConfig {}