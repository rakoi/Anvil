package com.anvil.rakoi.anvil.repos;


import com.anvil.rakoi.anvil.entities.Parcel;
import com.anvil.rakoi.anvil.entities.Trip;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TripRepository extends PagingAndSortingRepository<Trip,Integer> {


   @Query("SELECT t FROM Trip t WHERE t.origin LIKE %:search% or t.destination  like %:search%  order by t.id asc ")
   Page<Trip> searchData(String search, Pageable pageable);

   @Query(value="select * from trip inner join vehicle v on trip.vehicle_id = v.id where v.user_id=:userId",nativeQuery = true)
   Page<Trip> getUsersTrips(String userId, Pageable pageable);



}
