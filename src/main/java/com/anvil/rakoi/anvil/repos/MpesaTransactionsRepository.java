package com.anvil.rakoi.anvil.repos;

import com.anvil.rakoi.anvil.entities.Parcel;
import com.anvil.rakoi.anvil.entities.mpesatransactions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


public interface MpesaTransactionsRepository extends PagingAndSortingRepository<mpesatransactions,Integer>{


    mpesatransactions getById(int id);

    @Query(value="select id,parcel_id,date,amount,phone_number,mpesa_receipt_number,merchant_requestid, DATE_FORMAT(date, '%Y-%m-%d')  from mpesatransactions where amount=:amount and date_format(date, '%Y%m%d%H')=date_format(now(), '%Y%m%d%H') and phone_number=:phoneNumber order by id desc limit 0,1",nativeQuery = true)
    mpesatransactions fetchTransaction(String phoneNumber, String amount);

    @Query(value="select * from mpesatransactions where mpesa_receipt_number=:receiptNumber",nativeQuery = true)
    mpesatransactions findByMpesaReceiptNumber(String receiptNumber);
    Page<mpesatransactions> findAll(Pageable pageable);
    Page<mpesatransactions>  findAllByParcel(Parcel parcel, Pageable pageable);



}
