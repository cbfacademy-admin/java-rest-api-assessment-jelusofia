package com.cbfacademy.apiassessment.dao;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.cbfacademy.apiassessment.model.StockTransaction;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonFileHandler {
    private final Gson gson = new Gson();
    private final File jsonFile;
    private FileWriter fileWriter;  // Added field for dependency injection for the purpose if testing
    private Gson gsonInstance;  // Added field for dependency injection for the purpose if testing


    // Getter and setter for FileWriter
    public FileWriter getFileWriter() {
        return fileWriter;
    }

    public void setFileWriter(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    // Getter and setter for Gson
    public Gson getGson() {
        return gsonInstance;
    }

    public void setGson(Gson gsonInstance) {
        this.gsonInstance = gsonInstance;
    }

    public JsonFileHandler(String filePath) {
        this.jsonFile = new File(filePath);
    }

    public List<StockTransaction> readTransactions() throws IOException {
        List<StockTransaction> transactions = new ArrayList<>();

        if (jsonFile.exists() && jsonFile.length() > 0) {
            try (FileReader fileReader = new FileReader(jsonFile)) {
                Type type = new TypeToken<List<StockTransaction>>() {}.getType();
                transactions = gson.fromJson(fileReader, type);
                //return gson.fromJson(fileReader, type);
            }
        }
        return transactions;    
    }

    public void writeTransactions(List<StockTransaction> transactions) throws IOException {
        try (FileWriter fileWriter = new FileWriter(jsonFile)) {
            gson.toJson(transactions, fileWriter);
        }
    }
    
    public String transactionsListToJson(List<StockTransaction> transactions) {
        Type transactionListType = new TypeToken<List<StockTransaction>>() {}.getType();
        return gson.toJson(transactions, transactionListType);
    }
}
