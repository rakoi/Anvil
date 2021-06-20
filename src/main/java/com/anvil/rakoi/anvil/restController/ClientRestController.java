package com.anvil.rakoi.anvil.restController;

import com.anvil.rakoi.anvil.entities.Client;
import com.anvil.rakoi.anvil.services.ClientServiceImp;
import com.anvil.rakoi.anvil.services.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/client")
public class ClientRestController {

    @Autowired
    ClientServiceImp clientService;

    @GetMapping("/findByPhone/{phone}")

    public ResponseEntity<Client> findClientByPhoneNumber(@PathVariable String phone){
        Client client= clientService.findByphone_number(phone);

        if(client!=null){
               return ResponseEntity.ok().body(client);
        }else{
            System.out.println("Not found");
            return ResponseEntity.notFound().build();
        }

    }
    @GetMapping("/searchByPhone/{phone}")

    @CrossOrigin
    public ResponseEntity<List<Client>> searchByPhoneNumber(@PathVariable String phone){


        return ResponseEntity.ok().body(clientService.searchByPhoneNumber(phone));

    }
}
