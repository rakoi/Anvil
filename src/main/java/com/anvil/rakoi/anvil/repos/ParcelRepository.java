package com.anvil.rakoi.anvil.repos;

import com.anvil.rakoi.anvil.entities.Parcel;
import com.anvil.rakoi.anvil.entities.Station;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ParcelRepository extends JpaRepository<Parcel,Integer> {
    List<Parcel> findAllByOrigin(Station origin);
    List<Parcel>  findAllByDestination(Station origin);
    List<Parcel> findAllByCollectedFalseAndDestination(Station destination);
}
