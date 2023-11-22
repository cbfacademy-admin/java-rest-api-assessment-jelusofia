package com.cbfacademy.apiassessment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.Mockito;

import com.cbfacademy.apiassessment.dao.JsonFileHandler;
import com.cbfacademy.apiassessment.model.StockTransaction;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonFileHandlerTest {
    //Creating a temporary file
     @TempDir
    File tempDir;

    private JsonFileHandler jsonFileHandler;
    private File jsonFile;

    @BeforeEach
    void setUp() {
        jsonFile = new File(tempDir, "testTransactions.json");
        jsonFileHandler = new JsonFileHandler(jsonFile.getAbsolutePath());
    }

    @Test
    public void toJsonTest() {
        JsonFileHandler jsonFileHandler = new JsonFileHandler("test.json");

        // Creating some test data
        List<StockTransaction> transactions = List.of(
                new StockTransaction(UUID.randomUUID(), "TestProfit", 10, 100.0, 120.0, 5.0, 0.0)
                // might add more instances
        );

        // Use TypeToken to get the type of List<StockTransaction>
        Type transactionListType = new TypeToken<List<StockTransaction>>() {}.getType();

        // Act
        String jsonString = jsonFileHandler.toJson(transactions, transactionListType);
    }

    @Test
    void testReadTransactions() throws IOException {
        List<StockTransaction> expectedTransactions = new ArrayList<>();
        expectedTransactions.add(new StockTransaction(UUID.randomUUID(), "TestProfit", 10, 100.0, 120.0, 5.0, 0.0));

        jsonFileHandler.writeTransactions(expectedTransactions);

        List<StockTransaction> actualTransactions = jsonFileHandler.readTransactions();

        assertEquals(expectedTransactions, actualTransactions);
    }

    @Test
    void testWriteTransactions() throws IOException {
        Gson gson = new Gson();
        JsonFileHandler jsonFileHandler = new JsonFileHandler("test.json");

        List<StockTransaction> transactions = List.of(
            new StockTransaction(UUID.randomUUID(), "TestProfit", 10, 100.0, 120.0, 5.0, 0.0)
        );
        jsonFileHandler.writeTransactions(transactions);
        
        List<StockTransaction> actualTransactions = jsonFileHandler.readTransactions();
        assertEquals(transactions, actualTransactions);
        //jsonFileHandler.setFileWriter(mockFileWriter);
        //jsonFileHandler.setGson(mockGson);

        //jsonFileHandler.writeTransactions(new ArrayList<>());

        //Mockito.verify(mockFileWriter, Mockito.times(1)).write(Mockito.anyString());
    }
    
}
