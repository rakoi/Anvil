package com.anvil.rakoi.anvil.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.anvil.rakoi.anvil.entities.Vehicle;

public interface VehicleServiceInteface {

	Vehicle getVehicle(int id);
	void deleteVehicle(int id);
	Vehicle addVehicle(Vehicle vehicle);
	Page<Vehicle> getVehicle(Pageable pagable);
	
}
