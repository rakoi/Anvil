package com.anvil.rakoi.anvil.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anvil.rakoi.anvil.entities.Parcel;
import com.anvil.rakoi.anvil.entities.User;
import com.anvil.rakoi.anvil.services.ParcelServiceImpl;

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
			System.out.println("HERE");
			return ResponseEntity.notFound().build();
		}
		
	}

	@GetMapping("/deleteParcel/{id}")
	public ResponseEntity<?> deleteParcel(@PathVariable("id") int id) {
		parcelServiceImpl.DeleteParcel(id);
		return ResponseEntity.ok("Success");
	}

}
