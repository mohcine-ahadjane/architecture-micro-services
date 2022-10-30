package com.example.openlabbillingservicemohcine.mappers;

import com.example.openlabbillingservicemohcine.dto.InvoiceReqestDTO;
import com.example.openlabbillingservicemohcine.dto.InvoiceResponseDTO;
import com.example.openlabbillingservicemohcine.entities.Invoice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {
    Invoice fromInvoiceRequestDTO(InvoiceReqestDTO invoiceReqestDTO);
    InvoiceResponseDTO fromInvoice(Invoice invoice);
}
