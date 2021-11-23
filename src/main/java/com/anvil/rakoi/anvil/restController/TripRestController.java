package com.anvil.rakoi.anvil.restController;

import com.anvil.rakoi.anvil.entities.Parcel;
import com.anvil.rakoi.anvil.entities.Trip;
import com.anvil.rakoi.anvil.entities.User;
import com.anvil.rakoi.anvil.repos.TripRepository;
import com.anvil.rakoi.anvil.repos.VehicleRepository;
import com.anvil.rakoi.anvil.security.MyDetailsService;
import com.anvil.rakoi.anvil.security.MyUserDetails;
import com.anvil.rakoi.anvil.util.StringFunctions;
import com.google.gson.Gson;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import com.anvil.rakoi.anvil.services.TripServiceImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/trip")
public class TripRestController {
	
	@Autowired
	TripServiceImpl tripServiceImpl;
	@Autowired
	VehicleRepository vehicleRepository;

	@CrossOrigin
	@GetMapping("/all")
	public Page<Trip> getAllTrips(Pageable pageable,@Param(value="data") String data){

		String params="";


		if(data!=null){
			params=StringFunctions.getQueryParam(data);
			Integer pageNumber=Integer.parseInt(StringFunctions.getPageNumber(data));
			System.out.println(pageNumber);
			pageable=PageRequest.of(pageNumber,20,Sort.by("id"));
		}

		return tripServiceImpl.getTrips(pageable, params);

	}

	@GetMapping("/delete/{id}")
	public ResponseEntity<?> deleteTrip(@PathVariable("id") int id){

		try{
			tripServiceImpl.deleteTrip(id);
			  return new ResponseEntity<>("Success", HttpStatus.OK);
		}catch (Exception e){
			return new ResponseEntity<>("Success",HttpStatus.METHOD_FAILURE);
		}
	}

	@PostMapping("/add")
	public Integer addTrip(@RequestBody JSONObject  saveTrip){

		Gson g=new Gson();

		String tripJson=new Gson().toJson(saveTrip.get("Trip"));
		Trip trip=g.fromJson(tripJson,Trip.class);



		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();

		trip.setTimestamp(now.toString());

		tripServiceImpl.saveTrip(trip);
		Trip savedTrip=tripServiceImpl.saveTrip(trip);
		System.out.println(savedTrip);
		return savedTrip.getId();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Trip> getTrip(@PathVariable("id") int id) {

		try {
			Trip trip= tripServiceImpl.getTrip(id);
			return ResponseEntity.ok().body(trip);
		}catch(Exception e) {

			return ResponseEntity.notFound().build();
		}

	}

	@GetMapping("/finish/{id}")
	public ResponseEntity<Trip> finishTrip(@PathVariable("id") int id) {

		try {
			Trip updateTrip=tripServiceImpl.getTrip(id);
			updateTrip.setCompleted("Y");
			updateTrip.setArrival(StringFunctions.getCurrentTime());
			return ResponseEntity.ok().body(tripServiceImpl.updateTrip(updateTrip));
		}catch(Exception e) {

			return ResponseEntity.notFound().build();
		}

	}


	@PostMapping("/update")
	public ResponseEntity<Trip> updateTrip(@RequestBody  Trip trip) {

		try {
			Trip updateTrip=tripServiceImpl.getTrip(trip.getId());
			updateTrip.setVehicle(trip.vehicle);
			updateTrip.setDestination(trip.getDestination());
			updateTrip.setOrigin(trip.getOrigin());
			updateTrip.setDepature(trip.getDepature());
			return ResponseEntity.ok().body(tripServiceImpl.updateTrip(updateTrip));
		}catch(Exception e) {

			return ResponseEntity.notFound().build();
		}

	}


	@GetMapping("/user")
	public Page<Trip> getUsersTrips(Pageable pageable){

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		MyUserDetails user= (MyUserDetails) auth.getPrincipal();

		return tripServiceImpl.getUsersTrip(pageable,String.valueOf(user.getUserId()));

	}

	@GetMapping("/getParcels/{id}")
	public Page<Parcel> getParcels(@PathVariable("id") String tripId, Pageable pageable){
		pageable = PageRequest.of(pageable.getPageNumber(), 5, pageable.getSort());

		return  tripServiceImpl.getTripParcels(tripId,pageable);


	}

	@GetMapping("/removeParcel/{id}")
	public ResponseEntity<?> removeParcel(@PathVariable("id") Integer parcelId){


		try {
			tripServiceImpl.removeParcel(parcelId);
			return ResponseEntity.ok().body("success");
		}catch(Exception e) {

			return ResponseEntity.notFound().build();
		}


	}

	@GetMapping("/addParcel/{tripId}/{parcelId}")
	public ResponseEntity<?> addParcel(@PathVariable("tripId") Integer tripId,@PathVariable("parcelId") Integer parcelId){


		try {

			return ResponseEntity.ok().body(tripServiceImpl.addParcel(tripId,parcelId));
		}catch(Exception e) {

			return ResponseEntity.notFound().build();
		}


	}



}
