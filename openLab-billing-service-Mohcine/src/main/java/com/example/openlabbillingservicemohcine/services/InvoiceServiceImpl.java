package com.example.openlabbillingservicemohcine.services;

import com.example.openlabbillingservicemohcine.dto.InvoiceReqestDTO;
import com.example.openlabbillingservicemohcine.dto.InvoiceResponseDTO;
import com.example.openlabbillingservicemohcine.entities.Customer;
import com.example.openlabbillingservicemohcine.entities.Invoice;
import com.example.openlabbillingservicemohcine.exceptions.CustomerNotFoundException;
import com.example.openlabbillingservicemohcine.mappers.InvoiceMapper;
import com.example.openlabbillingservicemohcine.openfeign.CustomerRestClient;
import com.example.openlabbillingservicemohcine.repositories.InvoiceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional

public class InvoiceServiceImpl implements InvoiceService {
    private InvoiceRepository invoiceRepository;
    private InvoiceMapper invoiceMapper;
    private CustomerRestClient customerRestClient;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, InvoiceMapper invoiceMapper, CustomerRestClient customerRestClient) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceMapper = invoiceMapper;
        this.customerRestClient = customerRestClient;
    }


    @Override
    public InvoiceResponseDTO save(InvoiceReqestDTO invoiceReqestDTO) {
         /*
        verification de l'integrite referentoelle Invoice/customer
         */
        Customer customer=null;
        try{
            customer=customerRestClient.getCustomer(invoiceReqestDTO.getCustomerId());

        }
        catch (Exception e){
            throw new CustomerNotFoundException("Customer Not Found");
        }

        Invoice invoice=invoiceMapper.fromInvoiceRequestDTO(invoiceReqestDTO);
        invoice.setId(UUID.randomUUID().toString());
        invoice.setDate(new Date());

        Invoice saveInvoice=invoiceRepository.save(invoice);
        saveInvoice.setCustomer(customer);
        return invoiceMapper.fromInvoice(saveInvoice);
    }

    @Override
    public InvoiceResponseDTO getInvoice(String invoiceId) {
        Invoice invoice=invoiceRepository.findById(invoiceId).get();
        Customer customer=customerRestClient.getCustomer(invoice.getCustomerId());
        invoice.setCustomer(customer);
        return invoiceMapper.fromInvoice(invoice);
    }

    @Override
    public List<InvoiceResponseDTO> invoicesByCustomerId(String customerId) {
        List<Invoice> invoices=invoiceRepository.findByCustomerId(customerId);
        return invoices.
                stream()
                .map(invoice -> invoiceMapper.fromInvoice(invoice))
                .collect(Collectors.toList());
    }

    @Override
    public List<InvoiceResponseDTO> allInvoices() {
        List<Invoice> invoices=invoiceRepository.findAll();
        for (Invoice invoice:invoices) {
            Customer customer=customerRestClient.getCustomer(invoice.getCustomerId());
            invoice.setCustomer(customer);
        }
        return invoices.stream().map(inv ->
                invoiceMapper.fromInvoice(inv))
                        .collect(Collectors.toList());
    }
}
