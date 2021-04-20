package com.anvil.rakoi.anvil.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.anvil.rakoi.anvil.entities.Vehicle;
import com.anvil.rakoi.anvil.repos.VehicleRepository;

@Service
public class VehicleServiceImpl implements VehicleServiceInteface {
	
	@Autowired 
	VehicleRepository vehicleRepository;

	@Override
	public Vehicle getVehicle(int id) {
		
		return (Vehicle) vehicleRepository.findById(id).get();
	}

	@Override
	public void deleteVehicle(int id) {
		vehicleRepository.deleteById(id);
		
	}

	@Override
	public Vehicle addVehicle(Vehicle vehicle) {
		
		return (Vehicle) vehicleRepository.save(vehicle);
	}

	@Override
	public Page<Vehicle> getVehicle(Pageable pageable) {
		
		return vehicleRepository.findAll(pageable);
	}

}
