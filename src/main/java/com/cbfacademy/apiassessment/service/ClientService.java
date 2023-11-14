package com.cbfacademy.apiassessment.service;

import com.cbfacademy.apiassessment.model.Calculator;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cbfacademy.apiassessment.dao.ClientDao;
//change to calculatorservice.java
@Service
public class ClientService {
    private final ClientDao clientDao;

    @Autowired
    public ClientService(@Qualifier("Dao") ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public int addClient(Calculator client){
        return  clientDao.insertClient(client);
        //id double check 21:00 timestamp
    }

    public List<Calculator> getAllClients() {
        return clientDao.selectAllClients();
    }

    public Optional<Calculator> getClientById(UUID id) {
        return clientDao.selectClientById(id); //algo
    }

    public int deleteClient(UUID id){
        return  clientDao.deleteClientById(id);       
    }

    public int updateClient(UUID id, Calculator newClient){
        return  clientDao.updateClientById(id, newClient);       
    }//update calculation by calculation id

}
