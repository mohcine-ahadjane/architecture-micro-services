package com.example.openlabcustomerservicemohcine.repositories;

import com.example.openlabcustomerservicemohcine.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
