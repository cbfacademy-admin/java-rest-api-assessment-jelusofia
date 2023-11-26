package com.cbfacademy.apiassessment;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
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

    @Before
    public void setUp() {
        jsonFile = new File(tempDir, "testTransactions.json");
        jsonFileHandler = new JsonFileHandler(jsonFile.getAbsolutePath());
        jsonFileHandler.setGson(new Gson());
    }

    @Test
    public void toJsonTest() {
        // Creating some test data
        List<StockTransaction> transactions = List.of(
                new StockTransaction(UUID.randomUUID(), "TestProfit", 10, 100.0, 120.0, 5.0, 0.0)
        );

        // Act
        String jsonString = jsonFileHandler.transactionsListToJson(transactions);

       assertNotNull(jsonString);
       assertTrue(jsonString.contains("TestProfit"));
       assertTrue(jsonString.contains("100.0"));
    }

/*   @Test
    public void testReadTransactions() throws IOException {
        List<StockTransaction> expectedTransactions = new ArrayList<>();
        expectedTransactions.add(new StockTransaction(UUID.randomUUID(), "TestProfitone", 10, 100.0, 120.0, 5.0, 0.0));

        jsonFileHandler.writeTransactions(expectedTransactions);

        List<StockTransaction> actualTransactions = jsonFileHandler.readTransactions();

        assertEquals(expectedTransactions, actualTransactions);
    }

    @Test
    public void testWriteTransactions() throws IOException {
        List<StockTransaction> transactions = List.of(
                new StockTransaction(UUID.randomUUID(), "TestProfittwo", 10, 100.0, 120.0, 5.0, 0.0)
        );

        jsonFileHandler.writeTransactions(transactions);

        List<StockTransaction> actualTransactions = jsonFileHandler.readTransactions();
        assertEquals(transactions, actualTransactions);
    }
*/    
}
