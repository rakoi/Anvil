package com.anvil.rakoi.anvil;

import com.anvil.rakoi.anvil.repos.TripRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AnvilApplicationTests {

	@Autowired
	TripRepository tripRepository;


	@Test
	void testGetUser() {
		System.out.println("Test");
	}

	@Test
	void getOrigin() {


	}









}
