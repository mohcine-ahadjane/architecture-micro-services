package com.example.openlabbillingservicemohcine.web;

import com.example.openlabbillingservicemohcine.dto.InvoiceReqestDTO;
import com.example.openlabbillingservicemohcine.dto.InvoiceResponseDTO;
import com.example.openlabbillingservicemohcine.services.InvoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class InvoiceRestController {
    private InvoiceService invoiceService;

    public InvoiceRestController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }



    @GetMapping(path = "/invoices/{id}")
    public InvoiceResponseDTO getInvoice(@PathVariable(name= "id") String invoiceId){
        return  invoiceService.getInvoice(invoiceId);
    }
    @GetMapping(path = "/invoicesByCustomer/{customerId}")
    public List<InvoiceResponseDTO> getInvoicesByCustomerId(@PathVariable String customerId){
        return invoiceService.invoicesByCustomerId(customerId);
    }
@PostMapping(path = "/invoices")
    public InvoiceResponseDTO save(@RequestBody InvoiceReqestDTO invoiceReqestDTO){
        return invoiceService.save(invoiceReqestDTO);
    }

    @GetMapping(path = "/invoices")
    public List<InvoiceResponseDTO> allInvoices(){
        return invoiceService.allInvoices();
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
