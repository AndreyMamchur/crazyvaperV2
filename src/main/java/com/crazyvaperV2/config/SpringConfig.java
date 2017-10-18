package com.crazyvaperV2.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.crazyvaperV2.dao", "com.crazyvaperV2.service"})
public class SpringConfig {
}
