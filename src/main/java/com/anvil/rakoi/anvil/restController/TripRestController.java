package com.anvil.rakoi.anvil.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import com.anvil.rakoi.anvil.services.TripServiceImpl;
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/trip")
public class TripRestController {
	
	@Autowired
	TripServiceImpl tripServiceImpl;

	@CrossOrigin
	@GetMapping("/all")
	public void  getAllTrips(Pageable pageable){

	System.out.println("HELLOO");

	}
//
//	@GetMapping("/get/{id}")
//	public Trip getTrip(@PathVariable int id) {
//		return tripServiceImpl.getTrip(id);
//	}
//	@GetMapping("/delete/{id}")
//	public ResponseEntity<?> deleteTrip(@PathVariable int id) {
//
//		tripServiceImpl.deleteTrip(id);
//
//		return ResponseEntity.ok("success");
//	}

}
