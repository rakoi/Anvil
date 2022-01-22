package com.anvil.rakoi.anvil.services;

import com.anvil.rakoi.anvil.entities.Station;
import com.anvil.rakoi.anvil.repos.ParcelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.anvil.rakoi.anvil.entities.Parcel;
import com.anvil.rakoi.anvil.repos.ParcelPagingAndSortingRepository;

@Service
public class ParcelServiceImpl implements ParcellServiceInterface {

	@Autowired
	ParcelPagingAndSortingRepository parcelPagingAndSortingRepository;
	@Autowired
	ParcelRepository parcelRepository;


	@Override
	public void DeleteParcel(int id) {
		 parcelPagingAndSortingRepository.deleteById(id);
	}

	@Override
	public Parcel getParcelById(int id) {
		System.out.println("getting parcel by id"+id);

		return parcelRepository.findById(id).get();
	}

	@Override
	public Parcel SaveParcel(Parcel Parcel) {
		
		return parcelPagingAndSortingRepository.save(Parcel);
	}

	@Override
	public Page<Parcel> getAllParcel(org.springframework.data.domain.Pageable pageable) {
		
		return parcelPagingAndSortingRepository.findAll(pageable);
	}
	public Page<Parcel> findSentParcels(Station origin, org.springframework.data.domain.Pageable pageable){
		return  parcelPagingAndSortingRepository.findAllByOrigin(origin,pageable);
	}

	public Page<Parcel> findByDestination(Station destination,org.springframework.data.domain.Pageable pageable){
		return  parcelPagingAndSortingRepository.findAllByDestination(destination,pageable);
	}
	public Page<Parcel> findUncollected(Station destination,org.springframework.data.domain.Pageable pageable){
		return  parcelPagingAndSortingRepository.findAllByCollectedFalseAndDestination(destination,pageable);
	}




}
