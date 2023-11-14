package com.cbfacademy.apiassessment.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.cbfacademy.apiassessment.model.Client;

@Repository("Dao")
public class ClientDataAccessService implements ClientDao {
    private static List<Client> DB = new ArrayList<>(); //Write it to JSON file using gson library


    @Override
    public int insertClient(UUID id, Client client) {
        DB.add(new Client(id, client.getName()));
        return 1;
       // throw new UnsupportedOperationException("Unimplemented method 'insertClient'");
    }

    @Override
    public List<Client> selectAllClients() {
        return DB;
    }

    @Override
    public Optional<Client> selectClientById(UUID id) {
        // TODO Auto-generated method stub
        return DB.stream()
                .filter(client -> client.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteClientById(UUID id) {
        Optional<Client> clientMaybe = selectClientById(id);
        if (clientMaybe.isEmpty()) {
            return 0;
        }
        DB.remove(clientMaybe.get());
        return 1;
    }

    @Override
    public int updateClientById(UUID id, Client update) {
       return selectClientById(id)
                .map(client -> { //note: learn more about map
                    int indexOfClientToUpdate = DB.indexOf(client);
                    if (indexOfClientToUpdate >= 0){
                        DB.set(indexOfClientToUpdate, new Client(id, update.getName()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }


}
