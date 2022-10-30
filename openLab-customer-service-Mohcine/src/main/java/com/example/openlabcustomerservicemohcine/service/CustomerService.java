package com.example.openlabcustomerservicemohcine.service;

import com.example.openlabcustomerservicemohcine.dto.CustomerRequestDTO;
import com.example.openlabcustomerservicemohcine.dto.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {
    CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO);
    CustomerResponseDTO getCustomer(String id);
    CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO);
    List<CustomerResponseDTO> listCustumers();

}
