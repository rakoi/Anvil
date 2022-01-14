package com.anvil.rakoi.anvil.services;

import com.anvil.rakoi.anvil.entities.Invoice;
import com.anvil.rakoi.anvil.entities.Parcel;
import com.anvil.rakoi.anvil.repos.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class InvoiceServiceInterfaceImpl implements InvoiceServiceInterface{

    @Autowired
    InvoiceRepository invoiceRepository;
    @Override
    public Page<Invoice> findAll(Pageable pageable) {
        return invoiceRepository.findAll(pageable);
    }

    @Override
    public Page<Invoice> findByParcel(Parcel parcel, Pageable pageable) {
        return invoiceRepository.findAllByParcel(parcel,pageable);
    }

    @Override
    public Invoice findById(Integer id) {
        return invoiceRepository.findById(id).get();
    }

    @Override
    public Invoice saveInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }


}
