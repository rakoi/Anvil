package com.anvil.rakoi.anvil.services;

import java.awt.print.Pageable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.anvil.rakoi.anvil.entities.Parcel;
import com.anvil.rakoi.anvil.repos.ParcelRepository;
@Service
public class ParcelServiceImpl implements ParcellServiceInterface {

	@Autowired
	ParcelRepository parcelRepository;
	


	@Override
	public void DeleteParcel(int id) {
		 parcelRepository.deleteById(id);
	}

	@Override
	public Parcel getParcelById(int id) {
	
		return parcelRepository.findById(id).get();
	}

	@Override
	public Parcel SaveParcel(Parcel Parcel) {
		
		return parcelRepository.save(Parcel);
	}

	@Override
	public Page<Parcel> getAllParcel(org.springframework.data.domain.Pageable pageable) {
		
		return parcelRepository.findAll(pageable);
	}

}