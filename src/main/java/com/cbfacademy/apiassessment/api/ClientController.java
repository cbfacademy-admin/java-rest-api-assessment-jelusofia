package com.cbfacademy.apiassessment.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cbfacademy.apiassessment.model.Client;
import com.cbfacademy.apiassessment.service.ClientService;

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
}
