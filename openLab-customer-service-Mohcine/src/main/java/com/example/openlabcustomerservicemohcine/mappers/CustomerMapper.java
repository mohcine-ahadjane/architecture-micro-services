package com.example.openlabcustomerservicemohcine.mappers;

import com.example.openlabcustomerservicemohcine.dto.CustomerRequestDTO;
import com.example.openlabcustomerservicemohcine.dto.CustomerResponseDTO;
import com.example.openlabcustomerservicemohcine.entities.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerResponseDTO customerToCustomerResponseDTO(Customer customer);
    Customer customerRequestDTOToCustomer(CustomerRequestDTO customerRequestDTO);


}
