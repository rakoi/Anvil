package com.anvil.rakoi.anvil.restController;

import com.anvil.rakoi.anvil.entities.Client;
import com.anvil.rakoi.anvil.entities.SaveParcelEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.anvil.rakoi.anvil.entities.Parcel;
import com.anvil.rakoi.anvil.entities.User;
import com.anvil.rakoi.anvil.services.ParcelServiceImpl;

import java.io.DataInput;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/parcel")
public class ParcelRestController {

	@Autowired
	ParcelServiceImpl parcelServiceImpl;

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
		return ResponseEntity.ok("Success");
	}

	@PostMapping("/addParcel")
	public ResponseEntity<?> addParcel(@RequestBody JSONObject saveParcelEntity) throws JsonProcessingException {

		//Gson gson= new Gson();
		//Parcel parcel= (Parcel) saveParcelEntity.get("parcel");

		//System.out.println(parcel.toString());
		return ResponseEntity.ok("Success");
	}

}
