package com.example.number;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NumberApplication {
	
	@Autowired
    	NumberRepository numberRepository;

	public static void main(String[] args) {
		SpringApplication.run(NumberApplication.class, args);
	}
	
	/**
     	* Auto populate the Number with 0 in database
     	* @return
     	*/
	@Bean
    	InitializingBean sendDatabase() {
        	return () -> numberRepository.save(new Number(0));
    	}

}
