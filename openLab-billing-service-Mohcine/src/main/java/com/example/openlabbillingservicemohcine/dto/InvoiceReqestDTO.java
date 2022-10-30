package com.example.openlabbillingservicemohcine.dto;

import com.example.openlabbillingservicemohcine.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;


@Data @NoArgsConstructor @AllArgsConstructor
public class InvoiceReqestDTO {
    private BigDecimal amount;
    private String customerId;

}
