package com.example.scooter;
import com.example.scooter.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScooterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScooterApplication.class, args);
	}

	@Autowired
	private CustomerRepository customerRepository;

}
