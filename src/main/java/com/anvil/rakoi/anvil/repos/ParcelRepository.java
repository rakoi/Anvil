package com.anvil.rakoi.anvil.repos;

import com.anvil.rakoi.anvil.entities.Parcel;
import com.anvil.rakoi.anvil.entities.Station;
import com.anvil.rakoi.anvil.entities.Trip;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface ParcelRepository extends PagingAndSortingRepository<Parcel,Integer> {
    Page<Parcel> findAllByOrigin(Station origin, Pageable pageable);
    Page<Parcel>  findAllByDestination(Station origin, Pageable pageable);
    Page<Parcel> findAllByCollectedFalseAndDestination(Station destination, Pageable pageable);
    Page<Parcel> findAllByTrip(Trip trip, Pageable pageable);

    @Query(value=" select * from parcel where payment_method=\"invoice\" and invoice_id is null",nativeQuery = true)
    List<Parcel> getAllParcelsWithNullInvoices();


    @Query(value="select * from parcel where payment_method=\"invoice\" and invoice_id is null group by sender",nativeQuery = true)
    List<Parcel> getSendersWithParcelsWithNullInvoices();


    @Query(value=" select * from parcel where payment_method=\"invoice\" and invoice_id is null and sender=:id",nativeQuery = true)
    List<Parcel>getParcelsWithNullInvoicesBySender (int id);





}
