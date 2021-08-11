package com.anvil.rakoi.anvil.repos;

import com.anvil.rakoi.anvil.entities.Station;
import org.springframework.data.domain.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.anvil.rakoi.anvil.entities.Parcel;

public interface ParcelRepository extends  PagingAndSortingRepository<Parcel,Integer> {

	    Page<Parcel> findAllByOrigin(Station origin,Pageable pageable);
		Page<Parcel>  findAllByDestination(Station origin, Pageable pageable);
		Page<Parcel> findAllByCollectedFalseAndDestination(Station destination, Pageable pageable);

}
