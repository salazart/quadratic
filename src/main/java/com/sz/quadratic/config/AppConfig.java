package com.sz.quadratic.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.sz.quadratic.dao.impl.QuadraticDaoImpl;
import com.sz.quadratic.interfaces.IQuadraticDao;
import com.sz.quadratic.models.Quadratic;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.sz.quadratic.config" })
public class AppConfig {
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:~/test");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		return dataSource;
	}
	
	private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");
        properties.put("hibernate.hbm2ddl.auto", "create");
        return properties;        
    }
	@Bean
	public JpaTransactionManager transactionManager(){
		JpaTransactionManager transactionManager = new JpaTransactionManager(
				getEntityManagerFactoryBean().getObject());
		return transactionManager;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean(){
		LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		localContainerEntityManagerFactoryBean.setDataSource(dataSource());
		localContainerEntityManagerFactoryBean.setPersistenceProvider(new HibernatePersistenceProvider());
		localContainerEntityManagerFactoryBean.setPackagesToScan("com.sz.quadratic.models");
		localContainerEntityManagerFactoryBean.setJpaProperties(hibernateProperties());
		return localContainerEntityManagerFactoryBean;
	}
	
	@Bean
	public IQuadraticDao quadraticDaoImpl(){
		return new QuadraticDaoImpl();
	}
	
	@Bean
	public Quadratic quadratic1(){
		return new Quadratic(5,9,3);
	}
}
