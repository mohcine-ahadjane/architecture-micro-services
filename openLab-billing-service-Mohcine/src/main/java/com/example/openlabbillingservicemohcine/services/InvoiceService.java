package com.example.openlabbillingservicemohcine.services;

import com.example.openlabbillingservicemohcine.dto.InvoiceReqestDTO;
import com.example.openlabbillingservicemohcine.dto.InvoiceResponseDTO;

import java.util.List;

public interface InvoiceService {
    public InvoiceResponseDTO save(InvoiceReqestDTO invoiceReqestDTO);
    InvoiceResponseDTO getInvoice(String  invoiceId);
    List<InvoiceResponseDTO> invoicesByCustomerId(String customerId);
    List<InvoiceResponseDTO> allInvoices();
}
