package com.anvil.rakoi.anvil.restController;

import com.anvil.rakoi.anvil.entities.*;
import com.anvil.rakoi.anvil.repos.ParcelRepository;
import com.anvil.rakoi.anvil.repos.StationRepository;
import com.anvil.rakoi.anvil.security.MyUserDetails;
import com.anvil.rakoi.anvil.services.ClientServiceImp;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.anvil.rakoi.anvil.services.ParcelServiceImpl;

import java.io.DataInput;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.data.domain.Sort.Order;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/parcel")
public class ParcelRestController {

	@Autowired
	ParcelServiceImpl parcelServiceImpl;
	@Autowired
	ClientServiceImp clientServiceImp;
	@Autowired
	ParcelServiceImpl parcelService;

	@Autowired
	StationRepository stationRepository;

	@Autowired
	ParcelRepository parcelRepository;


	@GetMapping("/all")
	public Page<Parcel> getallParcels(Pageable pageable) {
		System.out.println("GETTING PARCELS");
		return parcelServiceImpl.getAllParcel(pageable);
	}

	@GetMapping("/getParcel/{id}")
	public ResponseEntity<Parcel> getParcel(@PathVariable("id") int id) {
		
		try {
			Parcel parcel= parcelServiceImpl.getParcelById(id);
			return ResponseEntity.ok().body(parcel);
		}catch(Exception e) {

			return ResponseEntity.notFound().build();
		}
		
	}

	@GetMapping("/deleteParcel/{id}")
	public ResponseEntity<?> deleteParcel(@PathVariable("id") int id) {
		parcelServiceImpl.DeleteParcel(id);
		return new ResponseEntity<>("Success",HttpStatus.OK);
	}
	@GetMapping("/findByOrigin")
	public ResponseEntity<?> findByOrigin(@RequestParam(value = "sort",defaultValue = "id") String search,
										  @RequestParam(value = "per_page", defaultValue = "10") Integer limit,
										  @RequestParam(value = "page", defaultValue = "0") Integer page) {

		int length=search.length();
		PageRequest pageable=null;
		if(length>3) {
			String column = search.substring(0, length - 4);

			 pageable =PageRequest.of(page, limit, Sort.by(column));
		}else{


				pageable = PageRequest.of(page, limit, Sort.by(search));

		}

		System.out.println(pageable);

		MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int station_id=userDetails.getUserStation();
		Optional<Station> station=stationRepository.findById(station_id);
		Page<Parcel> outgoing = parcelServiceImpl.findSentParcels(station.get(), pageable);

		return new ResponseEntity<>(outgoing,HttpStatus.OK);
	}
	@GetMapping("/findAllByOrigin")
	public ResponseEntity<?> findByOrigin() {
		MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int station_id=userDetails.getUserStation();
		Optional<Station> station=stationRepository.findById(station_id);
		System.out.println(station_id);
		return new ResponseEntity<>(parcelRepository.findAllByOrigin(station.get()),HttpStatus.OK);
	}
	@GetMapping("/findUncollected")
	public ResponseEntity<?> findUncollected(@RequestParam(value = "sort",defaultValue = "id") String search,
											 @RequestParam(value = "per_page", defaultValue = "10") Integer limit,
											 @RequestParam(value = "page", defaultValue = "0") Integer page) {

		int length=search.length();
		PageRequest pageable=null;
		if(length>3) {
			String column = search.substring(0, length - 4);

			pageable =PageRequest.of(page, limit, Sort.by(column));
		}else{


			pageable = PageRequest.of(page, limit, Sort.by(search));

		}


		MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int station_id=userDetails.getUserStation();
		Optional<Station> station=stationRepository.findById(station_id);
		Page<Parcel> uncollected = parcelServiceImpl.findUncollected(station.get(), pageable);

		return new ResponseEntity<>(uncollected,HttpStatus.OK);
	}	@GetMapping("/findAllUncollected")
	public ResponseEntity<?> findUncollected() {


		MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int station_id=userDetails.getUserStation();
		Optional<Station> station=stationRepository.findById(station_id);

		return new ResponseEntity<>(parcelRepository.findAllByCollectedFalseAndDestination(station.get()),HttpStatus.OK);
	}


	@GetMapping("/incoming")
	public ResponseEntity<?> getincoming(@RequestParam(value = "sort",defaultValue = "id") String search,
										 @RequestParam(value = "per_page", defaultValue = "10") Integer limit,
										 @RequestParam(value = "page", defaultValue = "0") Integer page) {

		int length=search.length();
		PageRequest pageable=null;
		if(length>3) {
			String column = search.substring(0, length - 4);

			pageable =PageRequest.of(page, limit, Sort.by(column));
		}else{


			pageable = PageRequest.of(page, limit, Sort.by(search));

		}


		MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int station_id=userDetails.getUserStation();
		Optional<Station> station=stationRepository.findById(station_id);
		Page<Parcel> incoming = parcelServiceImpl.findByDestination(station.get(), pageable);

		return new ResponseEntity<>(incoming,HttpStatus.OK);
	}
	@GetMapping("/allincoming")
	public ResponseEntity<?> getincoming() {


		MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int station_id=userDetails.getUserStation();
		Optional<Station> station=stationRepository.findById(station_id);

		return new ResponseEntity<>(parcelRepository.findAllByDestination(station.get()),HttpStatus.OK);
	}


	@PostMapping("/addParcel")
	public ResponseEntity<?> addParcel(@RequestBody JSONObject saveParcelEntity) throws JsonProcessingException {
		Gson gson = new Gson();
		String parcelJson=new Gson().toJson(saveParcelEntity.get("parcel"));
		Parcel parcel=gson.fromJson(parcelJson,Parcel.class);

		String senderJson=new Gson().toJson(saveParcelEntity.get("sender"));
		Client sender=gson.fromJson(senderJson,Client.class);

		String receiverJson=new Gson().toJson(saveParcelEntity.get("reciever"));
		Client reciever=gson.fromJson(receiverJson,Client.class);

		System.out.println(parcel);
		if (reciever.getId()==0){
			 reciever=	clientServiceImp.addClient(reciever);

		}
		if(sender.getId()==0){
			sender=clientServiceImp.addClient(sender);
		}

		parcel.setSender(sender);
		parcel.setReciever(reciever);

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		parcel.setTimestamp(dtf.format(now));

		Parcel savedParcel =parcelService.SaveParcel(parcel);



		return new ResponseEntity<>(savedParcel,  HttpStatus.OK);
	}



}
