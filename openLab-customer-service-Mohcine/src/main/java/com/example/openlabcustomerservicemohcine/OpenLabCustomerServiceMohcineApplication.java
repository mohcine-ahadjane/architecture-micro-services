package com.example.openlabcustomerservicemohcine;

import com.example.openlabcustomerservicemohcine.dto.CustomerRequestDTO;
import com.example.openlabcustomerservicemohcine.service.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OpenLabCustomerServiceMohcineApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenLabCustomerServiceMohcineApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CustomerService customerService){
        return args -> {
            customerService.save(new CustomerRequestDTO("C01","Mohcine", "mohcine@gmail.com"));
            customerService.save(new CustomerRequestDTO("C02","Hafsa", "hafsa@gmail.com"));
            customerService.save(new CustomerRequestDTO("C03","ahd", "ahd@gmail.com"));
        };
    }

}
