package com.anvil.rakoi.anvil.repos;

import org.springframework.data.domain.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.anvil.rakoi.anvil.entities.Parcel;

public interface ParcelRepository extends  PagingAndSortingRepository<Parcel,Integer> {

	    Page<Parcel> findAllByOrigin(String origin,Pageable pageable);
		Page<Parcel>  findAllByDestination(String origin,Pageable pageable);
		Page<Parcel> findAllByCollectedFalseAndOrigin(String destination, Pageable pageable);

}
