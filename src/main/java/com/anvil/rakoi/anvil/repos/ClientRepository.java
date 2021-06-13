package com.anvil.rakoi.anvil.repos;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.jpa.repository.Query;
import com.anvil.rakoi.anvil.entities.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientRepository extends PagingAndSortingRepository<Client,Integer> {

    Client findByEmail(String email);
    Client findByPhone(String phoneNumber);

    List<Client> findByPhoneContains(String phone);
}
