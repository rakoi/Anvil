package com.anvil.rakoi.anvil.services;

import com.anvil.rakoi.anvil.entities.Invoice;
import com.anvil.rakoi.anvil.entities.Parcel;
import com.anvil.rakoi.anvil.repos.InvoiceRepository;
import com.anvil.rakoi.anvil.repos.ParcelRepository;
import com.anvil.rakoi.anvil.util.StringFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceServiceInterfaceImpl implements InvoiceServiceInterface{

    @Autowired
    InvoiceRepository invoiceRepository;
    @Autowired
    ParcelRepository parcelRepository;

    @Override
    public Page<Invoice> findAll(Pageable pageable) {
        return invoiceRepository.findAll(pageable);
    }



    @Override
    public Invoice findById(Integer id) {
        return invoiceRepository.findById(id).get();
    }

    @Override
    public Invoice saveInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }


    public void generateInvoices(){

       List<Parcel> parcelList= new ArrayList<>();
       parcelList=parcelRepository.getSendersWithParcelsWithNullInvoices();//all null invoice
       if(parcelList.size()>0){
            for(Parcel parcel:parcelList){
                //get parcels by specific senders
                List<Parcel> parcelBySender=parcelRepository.getParcelsWithNullInvoicesBySender(parcel.getSender().getId());
                Invoice invoice=new Invoice();
                invoice.setStatus(false);
                invoice.setDate(StringFunctions.getCurrentTime());
                invoice.setClient(parcel.getSender());
               invoice= invoiceRepository.save(invoice);
                for(Parcel updateParcel:parcelBySender){
                    updateParcel.setInvoice(invoice);
                    parcelRepository.save(updateParcel);
                }
            }
       }

    }


}
