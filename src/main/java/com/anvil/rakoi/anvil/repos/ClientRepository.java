package com.anvil.rakoi.anvil.repos;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.anvil.rakoi.anvil.entities.Client;

public interface ClientRepository extends PagingAndSortingRepository<Client,Integer> {

}
