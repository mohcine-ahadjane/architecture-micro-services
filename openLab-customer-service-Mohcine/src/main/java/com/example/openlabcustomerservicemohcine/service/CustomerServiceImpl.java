package com.example.openlabcustomerservicemohcine.service;

import com.example.openlabcustomerservicemohcine.dto.CustomerRequestDTO;
import com.example.openlabcustomerservicemohcine.dto.CustomerResponseDTO;
import com.example.openlabcustomerservicemohcine.entities.Customer;
import com.example.openlabcustomerservicemohcine.mappers.CustomerMapper;
import com.example.openlabcustomerservicemohcine.repositories.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional

public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }



    @Override
    public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO) {
        /*
        Mapping Objet Objet
         */
//        Customer customer=new Customer();
//        customer.setId(customerRequestDTO.getId());
//        customer.setName(customerRequestDTO.getName());
//        customer.setEmail(customerRequestDTO.getEmail());
//        customer.setId(UUID.randomUUID().toString());
        Customer customer=customerMapper.customerRequestDTOToCustomer(customerRequestDTO);
        Customer savedCustomer=customerRepository.save(customer);

        /*
        Mapping Objet Objet
         */
//        CustomerResponseDTO customerResponseDTO=new CustomerResponseDTO();
//        customerResponseDTO.setId(savedCustomer.getId());
//        customerResponseDTO.setId(savedCustomer.getName());
//        customerResponseDTO.setEmail(savedCustomer.getEmail());

        CustomerResponseDTO customerResponseDTO=customerMapper.customerToCustomerResponseDTO(savedCustomer);
        return customerResponseDTO;
    }

    @Override
    public CustomerResponseDTO getCustomer(String id) {
        Customer customer=customerRepository.findById(id).get();
        return customerMapper.customerToCustomerResponseDTO(customer);
    }

    @Override
    public CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO) {
        Customer customer=customerMapper.customerRequestDTOToCustomer(customerRequestDTO);
        Customer updatedCustomer = customerRepository.save(customer);
        return customerMapper.customerToCustomerResponseDTO(updatedCustomer);

    }

    @Override
    public List<CustomerResponseDTO> listCustumers() {
        List<Customer> customers=customerRepository.findAll();
        List<CustomerResponseDTO> customerResponseDTOS=
                customers.stream()
                        .map(customer -> customerMapper.customerToCustomerResponseDTO(customer))
                        .collect(Collectors.toList());
        return customerResponseDTOS;
    }
}
