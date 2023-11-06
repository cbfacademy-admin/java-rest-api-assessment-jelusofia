package com.cbfacademy.apiassessment.service;

import com.cbfacademy.apiassessment.model.Client;

import com.cbfacademy.apiassessment.dao.ClientDao;

public class ClientService {
    private final ClientDao clientDao;

    public ClientService(ClientDao clientDao) {
        this.clientDao = clientDao;

    }

    public int addClient(Client client){
        return  clientDao.insertClient(client);
        //id double check 21:00 timestamp
    }
}
