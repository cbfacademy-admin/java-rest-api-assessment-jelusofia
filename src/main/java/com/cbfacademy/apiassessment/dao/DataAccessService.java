package com.cbfacademy.apiassessment.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cbfacademy.apiassessment.model.StockTransaction;

@Repository("Dao")
public class DataAccessService implements StockTransactionDao {
    private final List<StockTransaction> DB = new ArrayList<>();
    private final JsonFileHandler jsonFileHandler;
    private static final Logger logger = LoggerFactory.getLogger(DataAccessService.class);

    public DataAccessService(@Value("${json.file.path}") String jsonFilePath) {
        this.jsonFileHandler = new JsonFileHandler(jsonFilePath);
        try {
            List<StockTransaction> transactions = jsonFileHandler.readTransactions();
            
            // Add null check before adding elements to DB
            if (transactions != null) {
                this.DB.addAll(transactions);
            }
        } catch (IOException e) {
            logger.error("An error occurred while reading/writing to the JSON file", e);
        }
    }


    @Override
    public int insertStockTransaction(UUID id, StockTransaction transaction) {
        DB.add(new StockTransaction(id, transaction.getName(), transaction.getQuantity(), transaction.getBuyingPrice(), transaction.getSellingPrice(), transaction.getCommission(), transaction.getProfit()));
        saveToJson();
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
                .filter(transaction -> transaction.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteTransactionById(UUID id) {
        Optional<StockTransaction> transactionMaybe = selectTransactionById(id);
        if (transactionMaybe.isEmpty()) {
            return 0;
        }
        DB.remove(transactionMaybe.get());
        saveToJson();
        return 1;
    }

    @Override
    public int updateTransactionById(UUID id, StockTransaction update) {
       return selectTransactionById(id)
                .map(transaction -> { //note: learn more about map
                    int indexOfTransactionToUpdate = DB.indexOf(transaction);
                    if (indexOfTransactionToUpdate >= 0){
                        DB.set(indexOfTransactionToUpdate, new StockTransaction(id, update.getName(), update.getQuantity(), update.getBuyingPrice(), update.getSellingPrice(), update.getCommission(), update.getProfit()));
                        saveToJson();
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

    private void saveToJson() {
        try {
            jsonFileHandler.writeTransactions(DB);
        } catch (IOException e) {
            logger.error("An error occurred while reading/writing (saving) to the JSON file", e);
            throw new RuntimeException("Failed to initialize DataAccessService", e);
        }
    }


}
