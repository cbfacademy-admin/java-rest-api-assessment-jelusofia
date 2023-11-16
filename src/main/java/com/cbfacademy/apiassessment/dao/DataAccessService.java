package com.cbfacademy.apiassessment.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.cbfacademy.apiassessment.model.StockTransaction;

@Repository("Dao")
public class DataAccessService implements StockTransactionDao {
    private static List<StockTransaction> DB = new ArrayList<>();


    @Override
    public int insertStockTransaction(UUID id, StockTransaction transaction) {
        DB.add(new StockTransaction(id, transaction.getName(), transaction.getQuantity(), transaction.getBuyingPrice(), transaction.getSellingPrice(), transaction.getCommission(), transaction.getProfit()));
        return 1; 
    } 


    @Override
    public List<StockTransaction> selectAllTransactions() {
        return DB;
    }

    @Override
    public Double profitCalculation(StockTransaction profit) {
        return 1.0;
    }



    @Override
    public Optional<StockTransaction> selectTransactionById(UUID id) {
        return DB.stream()
                .filter(client -> client.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteTransactionById(UUID id) {
        Optional<StockTransaction> clientMaybe = selectTransactionById(id);
        if (clientMaybe.isEmpty()) {
            return 0;
        }
        DB.remove(clientMaybe.get());
        return 1;
    }

    @Override
    public int updateTransactionById(UUID id, StockTransaction update) {
       return selectTransactionById(id)
                .map(client -> { //note: learn more about map
                    int indexOfClientToUpdate = DB.indexOf(client);
                    if (indexOfClientToUpdate >= 0){
                        DB.set(indexOfClientToUpdate, new StockTransaction(id, update.getName(), update.getQuantity(), update.getBuyingPrice(), update.getSellingPrice(), update.getCommission(), update.getProfit()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }


}
