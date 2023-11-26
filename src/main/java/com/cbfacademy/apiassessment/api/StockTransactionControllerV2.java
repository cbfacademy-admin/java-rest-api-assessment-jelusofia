package com.cbfacademy.apiassessment.api;

import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;

import com.cbfacademy.apiassessment.model.StockTransaction;
import com.cbfacademy.apiassessment.service.StockTransactionService;
import com.cbfacademy.apiassessment.service.StockTransactionServiceImpl;

/*VERSION 2 - Spring Boot RESTful API controller class
 * for handling HTTP requests related to stock transactions
*/
@SpringBootApplication
@RequestMapping("api/v2/pnlcalculator")
@RestController
public class StockTransactionControllerV2 {
    private StockTransactionService transactionService2;

    @Autowired
    public void StockTransactionController2(StockTransactionService transactionService2){
        this.transactionService2 = transactionService2;
    }

    @GetMapping("/calculateProfit")//HTTP GET requests to return the calculated profit without adding a new transaction.
    public double calculateProfit(
            @RequestParam String name,
            @RequestParam double sellingPrice,
            @RequestParam int quantity,
            @RequestParam double buyingPrice,
            @RequestParam double commission) {
        StockTransaction transaction = new StockTransaction(UUID.randomUUID(), name, quantity, buyingPrice, sellingPrice, commission, 0.0);
        return transaction.calculateProfit();
    }


    @PostMapping //HTTP POST requests to add a new transaction
    public void addTransaction( @Validated @NonNull @RequestBody StockTransaction transaction){
        System.err.println(transaction);
        transactionService2.addTransaction(transaction);
    }

    @GetMapping//HTTP GET requests to retrieve all transactions.
    public List<StockTransaction> getAllTransactions() {
        return transactionService2.getAllTransactions();
    }

    @GetMapping(path = "{id}")//HTTP GET requests to retrieve a transaction by its ID.
    public StockTransaction getTransactionById2(@PathVariable("id") UUID id) {
        return transactionService2.getTransactionById(id)
                .orElse(null);
    }
    @DeleteMapping(path = "{id}")//HTTP DELETE requests to delete a transaction by its ID.
    public void deleteTransactionById2(@PathVariable("id") UUID id) {
        transactionService2.deleteTransaction(id);
    }
    @PutMapping(path = "{id}")//HTTP PUT requests to update a transaction by its ID.
    public void updateCalculation2(@PathVariable("id") UUID id, @Validated @NonNull @RequestBody StockTransaction transactionToUpdate ) {
        transactionService2.updateTransaction(id, transactionToUpdate);
    }
    
}
