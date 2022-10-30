package com.example.openlabbillingservicemohcine.exceptions;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String messages) {
        super(messages);
    }
}
