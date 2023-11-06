package com.cbfacademy.apiassessment.dao;

import com.cbfacademy.apiassessment.model.Client;
import java.util.UUID;

public interface ClientDao {
    int insertClient(UUID id, Client client);

    default int insertClient(Client client){
        UUID id = UUID.randomUUID();
        return insertClient(id, client);
    }
}
