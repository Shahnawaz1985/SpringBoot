package com.bac.config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jms.JndiConnectionFactoryAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration(exclude={JndiConnectionFactoryAutoConfiguration.class,
		DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class,
		//JpaRepositoriesAutoConfiguration.class,
		//DataSourceTransactionManagerAutoConfiguration.class,
		SecurityAutoConfiguration.class})
@ComponentScan(basePackages = {"com.bac.controller", "com.bac.service", "com.bac.config"})
@EntityScan(basePackages = {"com.bac.domain"})
@EnableJpaRepositories(basePackages = "com.bac.repositories")
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);		
	}
	
	@Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
        };
    }

}
