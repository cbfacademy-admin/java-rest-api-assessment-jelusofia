package com.cbfacademy.apiassessment.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.cbfacademy.apiassessment.model.Client;

@Repository("Dao")
public class ClientDataAccessService implements ClientDao {
    private static List<Client> DB = new ArrayList<>();


    @Override
    public int insertClient(UUID id, Client client) {
        DB.add(new Client(id, client.getName()));
        return 1;
       // throw new UnsupportedOperationException("Unimplemented method 'insertClient'");
    }


}