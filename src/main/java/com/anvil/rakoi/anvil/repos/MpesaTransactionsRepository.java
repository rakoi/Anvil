package com.anvil.rakoi.anvil.repos;

import com.anvil.rakoi.anvil.entities.Parcel;
import com.anvil.rakoi.anvil.entities.mpesatransactions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MpesaTransactionsRepository extends PagingAndSortingRepository<mpesatransactions,Integer>{


    mpesatransactions getById(int id);
    Page<mpesatransactions> findAll(Pageable pageable);
    Page<mpesatransactions>  findAllByParcel(Parcel parcel, Pageable pageable);



}
