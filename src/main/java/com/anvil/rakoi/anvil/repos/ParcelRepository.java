package com.anvil.rakoi.anvil.repos;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.anvil.rakoi.anvil.entities.Parcel;

public interface ParcelRepository extends  PagingAndSortingRepository<Parcel,Integer> {

	

}
