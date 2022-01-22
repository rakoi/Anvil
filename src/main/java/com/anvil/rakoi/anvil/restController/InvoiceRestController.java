package com.anvil.rakoi.anvil.restController;

import com.anvil.rakoi.anvil.entities.Invoice;
import com.anvil.rakoi.anvil.entities.Parcel;
import com.anvil.rakoi.anvil.repos.ParcelRepository;
import com.anvil.rakoi.anvil.services.InvoiceServiceInterfaceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/invoice")
public class InvoiceRestController {

    @Autowired
    InvoiceServiceInterfaceImpl invoiceService;

    @Autowired
    ParcelRepository parcelRepository;

    @GetMapping("/all")
    public Page<Invoice> getAll(Pageable pageable) {

        return invoiceService.findAll(pageable);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Invoice> getParcel(@PathVariable("id") int id) {

        try {
          Invoice invoice= invoiceService.findById(id);
            return ResponseEntity.ok().body(invoice);
        }catch(Exception e) {

            return ResponseEntity.notFound().build();
        }

    }
    @GetMapping("/changePaidStatus/{id}")
    public ResponseEntity<Invoice> changePaidStatus(@PathVariable("id") int id) {

        try {
            Invoice invoice= invoiceService.findById(id);
            invoice.setStatus(!invoice.status);
            invoiceService.saveInvoice(invoice);
            return ResponseEntity.ok().body(invoice);
        }catch(Exception e) {

            return ResponseEntity.notFound().build();
        }

    }
}
