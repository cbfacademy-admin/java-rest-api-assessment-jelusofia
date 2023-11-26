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

import com.cbfacademy.apiassessment.model.StockTransaction;
/*This class is the data access service, providing methods 
//for CRUD operations on stock transactions with storage in data.JSON file
*/
@Repository("Dao")
public class DataAccessService implements StockTransactionDao {
    private final List<StockTransaction> DB = new ArrayList<>(); //DB represents an in-memory database of stock transactions
    private final JsonFileHandler jsonFileHandler; //An instance of the JsonFileHandler class
    private static final Logger logger = LoggerFactory.getLogger(DataAccessService.class); //SLF4J logger framework

    //Constructor - 
    //json.file.path is defined in the properties file - taken here as a parameter and
    //it reads transactions from the JSON file and adds them to the in-memory database (DB)
    public DataAccessService(@Value("${json.file.path}") String jsonFilePath) {
        this.jsonFileHandler = new JsonFileHandler(jsonFilePath);
        try {
            List<StockTransaction> transactions = jsonFileHandler.readTransactions();
            
            // Null check before adding elements to DB
            if (transactions != null) {
                this.DB.addAll(transactions);
            }
        } catch (IOException e) {
            logger.error("An error occurred while reading/writing to the JSON file", e);
        }
    }

    //Inserts a new stock transaction into the in-memory database and triggers a save to the JSON file.
    @Override
    public int insertStockTransaction(UUID id, StockTransaction transaction) {
        DB.add(new StockTransaction(id, transaction.getName(), transaction.getQuantity(), transaction.getBuyingPrice(), transaction.getSellingPrice(), transaction.getCommission(), transaction.getProfit()));
        saveToJson();
        return 1; 
    } 

    //Retrieves all stock transactions from the in-memory database.
    @Override
    public List<StockTransaction> selectAllTransactions() {
        return DB;
    }

    //A placeholder method
    @Override
    public Double profitCalculation(StockTransaction profit) {
        return 1.0;
    }

    //Searches for a stock transaction in the in-memory database by its UUID
    @Override
    public Optional<StockTransaction> selectTransactionById(UUID id) {
        return DB.stream()
                .filter(transaction -> transaction.getId().equals(id))
                .findFirst();
    }

    //Deletes a stock transaction from the in-memory database by its UUID and triggers a save to the JSON file
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

    //Updates a stock transaction in the in-memory database by its UUID and triggers a save to the JSON file.
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

    //Saves the current state of the in-memory database to the JSON file using the JsonFileHandler class.
    private void saveToJson() {
        try {
            jsonFileHandler.writeTransactions(DB);
        } catch (IOException e) {
            logger.error("An error occurred while reading/writing (saving) to the JSON file", e);
            throw new RuntimeException("Failed to initialize DataAccessService", e);
        }
    }


}
