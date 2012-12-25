package com.home.qh.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = { "com.home.qh", "com.home.qh.jpa" })
@Import({ CoreConfig.class, SecurityConfig.class })
public class RootConfig {}