package com.anvil.rakoi.anvil.repos;


import com.anvil.rakoi.anvil.entities.Trip;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TripDtRepository extends JpaRepository<Trip,Integer> {
    //DataTablesOutput<Trip> findAll(DataTablesInput i);
}
