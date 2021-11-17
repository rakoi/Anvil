package com.anvil.rakoi.anvil.repos;


import com.anvil.rakoi.anvil.entities.Trip;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TripRepository extends PagingAndSortingRepository<Trip,Integer> {

   // @Query("select id,origin,destination,depature,arrival from trip ")
   @Query("SELECT t FROM Trip t WHERE t.origin LIKE %:search% or t.destination  like %:search%  order by t.id asc ")
        Page<Trip> searchData(String search, Pageable pageable);


}
