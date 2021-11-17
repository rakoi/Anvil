package com.anvil.rakoi.anvil.restController;

import com.anvil.rakoi.anvil.entities.VehicleView;
import com.anvil.rakoi.anvil.repos.VehicleViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anvil.rakoi.anvil.entities.Vehicle;
import com.anvil.rakoi.anvil.services.VehicleServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleRestController {
	
	@Autowired
	VehicleServiceImpl vehicleServiceImpl;
	@Autowired
	VehicleViewRepository vehicleViewRepository;
	
	@GetMapping("/all")
	public Page<Vehicle> getAllVehicles(Pageable pageable){
		return vehicleServiceImpl.getVehicle(pageable);
	}

	@GetMapping("/get")
	public List<VehicleView> getAllVehicles(){

		return vehicleViewRepository.findAll();
	}


	@GetMapping("/get/{id}")
	public Vehicle getVehicle(@PathVariable int id) {
		
		return vehicleServiceImpl.getVehicle(id);
	}
	
	@GetMapping("/delete/{id}")
	public ResponseEntity<?> deleteVehicle(int id){
		vehicleServiceImpl.deleteVehicle(id);
			return ResponseEntity.ok("deleted");
	}
	
	
	
}
