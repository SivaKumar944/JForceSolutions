package com.hrs.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages= {"com.hrs.service"})
@Import(PersistanceConfig.class)
public class RootConfig {

}
