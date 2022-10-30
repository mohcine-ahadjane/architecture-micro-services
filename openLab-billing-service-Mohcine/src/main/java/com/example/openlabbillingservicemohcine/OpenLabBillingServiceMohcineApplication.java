package com.example.openlabbillingservicemohcine;

import com.example.openlabbillingservicemohcine.dto.InvoiceReqestDTO;
import com.example.openlabbillingservicemohcine.services.InvoiceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
@EnableFeignClients
public class OpenLabBillingServiceMohcineApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenLabBillingServiceMohcineApplication.class, args);
    }
    @Bean
    CommandLineRunner start(InvoiceService invoiceService){
        return args -> {
            invoiceService.save(new InvoiceReqestDTO(BigDecimal.valueOf(710000), "CO1"));
            invoiceService.save(new InvoiceReqestDTO(BigDecimal.valueOf(123000), "CO2"));
            invoiceService.save(new InvoiceReqestDTO(BigDecimal.valueOf(4560000), "CO1"));
        };

    }


}
