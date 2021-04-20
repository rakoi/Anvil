package com.anvil.rakoi.anvil.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.anvil.rakoi.anvil.entities.Trip;
import com.anvil.rakoi.anvil.repos.TripRepository;
import com.anvil.rakoi.anvil.services.TripServiceImpl;

@RestController
@RequestMapping("/api/trip")
public class TripRestController {
	
	@Autowired
	TripServiceImpl tripServiceImpl;
	
	@GetMapping("/all")
	public Page<Trip> getAllTrips(Pageable pageable){
		return tripServiceImpl.getTrips(pageable);
	}
	
	@GetMapping("/get/{id}")
	public Trip getTrip(@PathVariable int id) {
		return tripServiceImpl.getTrip(id);
	}
	@GetMapping("/delete/{id}")
	public ResponseEntity<?> deleteTrip(@PathVariable int id) {
			
		tripServiceImpl.deleteTrip(id);
		
		return ResponseEntity.ok("success");
	}

}
