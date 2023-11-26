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

//This class is has the methods used for writing and reading from the data.json file
//Using the GSON library


public class JsonFileHandler {
    private final Gson gson = new Gson(); //An instance of the Gson library, which is used for JSON serialization and deserialization.
    private final File jsonFile; // An object representing the JSON file to be read from or written to
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

    //Constructor 
    public JsonFileHandler(String filePath) {
        this.jsonFile = new File(filePath);
    }

    //Method to read from JSON file - deserialises JSON content into a list
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
    //Method to write to JSON file - serialises to JSON
    public void writeTransactions(List<StockTransaction> transactions) throws IOException {
        try (FileWriter fileWriter = new FileWriter(jsonFile)) {
            gson.toJson(transactions, fileWriter);
        }
    }
    //Method to convert a list to a JSON string
    public String transactionsListToJson(List<StockTransaction> transactions) {
        Type transactionListType = new TypeToken<List<StockTransaction>>() {}.getType();
        return gson.toJson(transactions, transactionListType);
    }
}
