package com.anvil.rakoi.anvil.services;

import com.anvil.rakoi.anvil.entities.Parcel;
import com.anvil.rakoi.anvil.entities.Trip;
import com.anvil.rakoi.anvil.repos.ParcelRepository;
import com.anvil.rakoi.anvil.repos.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TripServiceImpl implements TripServiceInterface {
	
	@Autowired
    TripRepository tripRepository;
	@Autowired
	ParcelRepository parcelRepository;

	@Override
	public Trip getTrip(int id) {

		return tripRepository.findById(id).get();
	}

	@Override
	public void deleteTrip(int id) {

		tripRepository.deleteById(id);

	}

	@Override
	public Page<Trip> getUsersTrip(Pageable pageable, String userId) {

		  return  tripRepository.getUsersTrips(userId,pageable);
	}

	@Override
	public Page<Parcel> getTripParcels(String tripId, Pageable pageable) {


		return parcelRepository.findAllByTrip(tripRepository.findById(Integer.parseInt(tripId)).get(),pageable);
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

	public void removeParcel(int parcelId){
		Parcel parcel=parcelRepository.findById(parcelId).get();
		parcel.setTrip(null);
		parcelRepository.save(parcel);
	}
	public Parcel addParcel(int tripId, int parcelId){
		Trip trip=tripRepository.findById(tripId).get();
		Parcel parcel=parcelRepository.findById(parcelId).get();

		parcel.setTrip(trip);
		return parcelRepository.save(parcel);
	}

	public Trip saveTrip(Trip trip){
		return tripRepository.save(trip);
	}
	public Trip updateTrip(Trip trip){
		return tripRepository.save(trip);
	}
}
