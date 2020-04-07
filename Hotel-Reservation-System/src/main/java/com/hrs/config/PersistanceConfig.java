package com.hrs.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages= {"com.hrs.dao"})
@PropertySource(value="classpath:db.properties")
@EnableTransactionManagement
public class PersistanceConfig {
	@Autowired
	private Environment env;
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource=new DriverManagerDataSource(env.getProperty("url"), env.getProperty("userdb"),env.getProperty("password"));
		dataSource.setDriverClassName(env.getProperty("driverClassName"));
		return dataSource;
	}
	@Bean(autowire=Autowire.BY_TYPE)
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate();
	}
	@Bean(autowire=Autowire.BY_TYPE)
	public PlatformTransactionManager manager() {
		return new DataSourceTransactionManager();
	}

}
