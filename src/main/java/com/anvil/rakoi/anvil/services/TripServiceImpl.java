package com.anvil.rakoi.anvil.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.anvil.rakoi.anvil.entities.Trip;
import com.anvil.rakoi.anvil.repos.TripRepository;

@Service
public class TripServiceImpl implements TripServiceInterface {
	
	@Autowired
	TripRepository tripRepository;

	@Override
	public Trip getTrip(int id) {
		
		return tripRepository.findById(id).get();
	}

	@Override
	public void deleteTrip(int id) {
		
		tripRepository.deleteById(id);
		
	}

	@Override
	public Page<Trip> getTrips(Pageable pageable) {
	
		return tripRepository.findAll(pageable);
	}

}
