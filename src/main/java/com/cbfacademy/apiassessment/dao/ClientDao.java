package com.cbfacademy.apiassessment.dao;

import com.cbfacademy.apiassessment.model.Calculator;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientDao {
    int insertClient(UUID id, Calculator client);

    default int insertClient(Calculator client){
        UUID id = UUID.randomUUID();
        return insertClient(id, client);
    }

    List<Calculator> selectAllClients();

    Optional<Calculator> selectClientById(UUID id);

    int deleteClientById(UUID id);

    int updateClientById(UUID id, Calculator client);
}
