package com.anvil.rakoi.anvil.services;

import com.anvil.rakoi.anvil.entities.Parcel;
import com.anvil.rakoi.anvil.entities.mpesatransactions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MpesaTransactionsInt {

    mpesatransactions getTransaction(int id);
    mpesatransactions saveTransaction(mpesatransactions mpesatransactions);
    Page<mpesatransactions> getMpesaTransactions(Pageable pageable);
    Page<mpesatransactions> getParcelTransaction(Parcel Parcel, Pageable pageable);
}
