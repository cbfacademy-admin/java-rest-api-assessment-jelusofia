package com.cbfacademy.apiassessment.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.cbfacademy.apiassessment.model.Client;

public class ClientDataAccessService implements ClientDao {
    private static List<Client> DB = new ArrayList<>();
    @Override
    public int insertPerson(UUID id, Client client){
        DB.add(new Client(id, client.getName()));
        return 1;
    }
}
