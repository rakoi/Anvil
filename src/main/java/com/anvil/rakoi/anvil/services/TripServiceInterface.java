package com.anvil.rakoi.anvil.services;

import com.anvil.rakoi.anvil.entities.Parcel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.anvil.rakoi.anvil.entities.Trip;

public interface TripServiceInterface {

	Trip getTrip(int id);
	void deleteTrip(int id);
	Page<Trip> getUsersTrip(Pageable pageable,String userId);
	Page<Parcel> getTripParcels(String tripId,Pageable pageable);
}
