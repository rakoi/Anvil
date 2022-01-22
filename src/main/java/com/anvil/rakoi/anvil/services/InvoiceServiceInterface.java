package com.anvil.rakoi.anvil.services;

import com.anvil.rakoi.anvil.entities.Invoice;
import com.anvil.rakoi.anvil.entities.Parcel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface InvoiceServiceInterface {

    Page<Invoice> findAll( Pageable pageable);
    Invoice findById(Integer id);
    Invoice saveInvoice(Invoice invoice);
}
