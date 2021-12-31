package com.anvil.rakoi.anvil.services;

import com.anvil.rakoi.anvil.entities.Parcel;
import com.anvil.rakoi.anvil.entities.mpesatransactions;
import com.anvil.rakoi.anvil.repos.MpesaTransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class MpesaTransactionsImpl  implements MpesaTransactionsInt{


    @Autowired
    MpesaTransactionsRepository mpesaTransactionsRepository;

    @Override
    public mpesatransactions getTransaction(int id) {
        return mpesaTransactionsRepository.getById(id);
    }

    @Override
    public mpesatransactions saveTransaction(mpesatransactions mpesatransaction) {
        return  mpesaTransactionsRepository.save(mpesatransaction);
    }

    @Override
    public Page<mpesatransactions> getMpesaTransactions(Pageable pageable) {
        return mpesaTransactionsRepository.findAll(pageable);
    }

    @Override
    public Page<mpesatransactions> getParcelTransaction(Parcel Parcel, Pageable pageable) {
        return mpesaTransactionsRepository.findAllByParcel(Parcel,pageable);
    }
}
