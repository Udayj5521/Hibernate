package com.centralbank;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CentralBankCustomerServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CentralBankCustomerServicesApplication.class, args);
	}

	
	/*@Bean
	 public CommandLineRunner DBInit() {
		return new DBInit();
	
	}*/
}
