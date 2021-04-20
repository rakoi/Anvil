package com.anvil.rakoi.anvil.repos;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.anvil.rakoi.anvil.entities.Vehicle;

public interface VehicleRepository extends PagingAndSortingRepository<Vehicle,Integer> {

}
