package com.anvil.rakoi.anvil.restController;


import com.anvil.rakoi.anvil.entities.Station;
import com.anvil.rakoi.anvil.repos.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/stations")
public class StationController {

    @Autowired
    StationRepository stationRepository;
    @GetMapping("/all")
    public ResponseEntity<?> getAllStations() {

        return new ResponseEntity<>( stationRepository.findAll(), HttpStatus.OK);
    }
}
