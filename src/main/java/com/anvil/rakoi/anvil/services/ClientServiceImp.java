package com.anvil.rakoi.anvil.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.anvil.rakoi.anvil.entities.Client;
import com.anvil.rakoi.anvil.repos.ClientRepository;

public class ClientServiceImp implements ClientServiceImpl {
	
	
	@Autowired
	ClientRepository clientRepository;
	
	
	@Override
	public Client findById(int id) {
		
		return clientRepository.findById(id).get();
	}

	@Override
	public List<Client> getAllClients() {
		
		return (List<Client>) clientRepository.findAll();
	}

	@Override
	public Page<Client> getAllClients(Pageable pageable) {
		
		return clientRepository.findAll(pageable);
	}

	@Override
	public void deleteClient(int id) {
		 clientRepository.deleteById(id);
		
	}

	@Override
	public void addClient(Client client) {
		clientRepository.save(client);
		
	}

}