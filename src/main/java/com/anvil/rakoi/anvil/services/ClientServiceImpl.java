package com.anvil.rakoi.anvil.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.anvil.rakoi.anvil.entities.Client;

public interface ClientServiceImpl  {

	
	Client findById(int id);
	List<Client> getAllClients();
	Page<Client> getAllClients(Pageable pageable);
	void deleteClient(int id);
	Client addClient(Client client);
	Client findByphone_number(String phoneNumber);
	List<Client> searchByPhoneNumber(String phoneNumber);
	
}

