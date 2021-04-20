package com.anvil.rakoi.anvil.services;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;

import com.anvil.rakoi.anvil.entities.Parcel;
import com.anvil.rakoi.anvil.entities.User;

public interface ParcellServiceInterface {
		
	Parcel SaveParcel(Parcel Parcel);
	void DeleteParcel(int id);
	Parcel getParcelById(int id);
	Page<Parcel> getAllParcel(org.springframework.data.domain.Pageable pageable);
	
}
