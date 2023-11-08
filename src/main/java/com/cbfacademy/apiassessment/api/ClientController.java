package com.cbfacademy.apiassessment.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbfacademy.apiassessment.model.Client;
import com.cbfacademy.apiassessment.service.ClientService;

@RequestMapping("api/v1/pnlcalculator")
@RestController
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService){
        this.clientService =clientService;
    }

    @PostMapping
    public void addClient(@RequestBody Client client){
        clientService.addClient(client);
    }

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping
    public Client getClientbyId(UUID ID) {
        return clientService.getAllClients();
    }

    
}
