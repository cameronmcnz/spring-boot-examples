package com.mcnz.spring.configuration;

import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;

@SpringBootApplication
public class SpringConfigurationExampleApplication  
                          implements CommandLineRunner {
	
	@Autowired
	SpringBootConfiguration config;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringConfigurationExampleApplication.class, args);
	} 
	
    @Override
    public void run(String... args) throws Exception  {
        System.out.println(config.getCompany());
        System.out.println(config.getSuite());
        System.out.println(config.isActive());
        
        System.out.println(config.getList().get(0));
        System.out.println(config.getMap());
        System.out.println(config.getInnerClass().getProperty1());
        
    }

}
