package com.cbfacademy.apiassessment.dao;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import com.cbfacademy.apiassessment.model.StockTransaction;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonFileHandler {
    private final Gson gson = new Gson();
    private final File jsonFile;

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
    }

    public void writeTransactions(List<StockTransaction> transactions) throws IOException {
        try (FileWriter fileWriter = new FileWriter(jsonFile)) {
            gson.toJson(transactions, fileWriter);
        }
    }
}
