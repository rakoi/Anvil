package com.anvil.rakoi.anvil.services;

import com.anvil.rakoi.anvil.entities.Trip;
import com.anvil.rakoi.anvil.repos.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

	public Page<Trip> getTrips(Pageable pageable,String destination) {

		if(destination!=null){
			System.out.println(destination+" is not null");

			return tripRepository.searchData(destination,pageable);
		}
		return tripRepository.findAll(pageable);
	}

	public Page<Trip> search(String string,Pageable pageable){
		return null;
		///return tripRepository.findByDestinationContaining(string,pageable);
	}

	public Trip saveTrip(Trip trip){
		return tripRepository.save(trip);
	}
	public Trip updateTrip(Trip trip){
		return tripRepository.save(trip);
	}
}
