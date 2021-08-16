package com.anvil.rakoi.anvil;

import java.util.Optional;
import java.util.Set;

import com.anvil.rakoi.anvil.entities.Client;
import com.anvil.rakoi.anvil.entities.Station;
import com.anvil.rakoi.anvil.repos.*;
import com.anvil.rakoi.anvil.services.ClientServiceImp;
import com.anvil.rakoi.anvil.services.ParcelServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.anvil.rakoi.anvil.entities.Role;
import com.anvil.rakoi.anvil.entities.User;
import org.springframework.data.domain.Pageable;

@SpringBootTest
class AnvilApplicationTests {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRespostory;

	@Autowired
	ClientServiceImp clientServiceImp;

	@Autowired
	ParcelRepository parcelRepository;

	@Autowired
	ClientRepository clientRepository;

	@Autowired
	ParcelServiceImpl parcelService;

	@Autowired
	StationRepository stationRepository;



	@Test
	void testGetUser() {
		try {
			Optional<User> user=userRepository.findById(1);	
			
		}catch(Exception e) {
			System.out.println(e);
		}		
	}
	@Test
	void testAddClient(){
		Client client=new Client ("James","Bond","jb@gmail.com","333333","076969688");
		System.out.println(client.toString());
		try{
			clientServiceImp.addClient(client);
		}catch (Exception e){
			System.out.println(e.toString());
		}

	}
	@Test
	void getClientByNumber(){
		System.out.println(clientServiceImp.findByphone_number("0702164611"));
	}

	@Test
	void searchByPhoneNumber(){
		System.out.println(clientServiceImp.searchByPhoneNumber("07").size());
	}

	@Test
	void getParcel(){
		System.out.println(parcelService.getParcelById(1));
	}

	@Test
	void getByDestination(){
		String station="1";

	}

	@Test
	void getByOrigin(){
		Optional<Station> station=stationRepository.findById(1);
		System.out.println(parcelService.findSentParcels(station.get(),null));
	}

	@Test
	void getAllParcels(){
		Optional<Station> station=stationRepository.findById(1);

		System.out.println(station.toString());
	}

	@Test
	void tesGetAllIncoming(){
		Optional<Station> station=stationRepository.findById(1);
		System.out.println(parcelRepository.findAllByDestination(station.get()));
	}
}
