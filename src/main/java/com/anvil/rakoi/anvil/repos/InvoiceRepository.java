package com.anvil.rakoi.anvil.repos;

import com.anvil.rakoi.anvil.entities.Invoice;
import com.anvil.rakoi.anvil.entities.Parcel;
import com.anvil.rakoi.anvil.entities.Station;
import com.anvil.rakoi.anvil.entities.Trip;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface InvoiceRepository  extends PagingAndSortingRepository<Invoice,Integer> {


    Invoice findById(int  id);
    Page<Invoice> findAll( Pageable pageable);
    Invoice save(Invoice invoice);

}
