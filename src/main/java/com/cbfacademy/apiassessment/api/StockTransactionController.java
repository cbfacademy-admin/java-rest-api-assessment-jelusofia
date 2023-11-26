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

/* Spring Boot RESTful API controller class
 * for handling HTTP requests related to stock transactions
*/
@RequestMapping("api/v1/pnlcalculator")
@RestController
public class StockTransactionController {
    private final StockTransactionService transactionService;

    //Constructor
    @Autowired
    public StockTransactionController(StockTransactionService transactionService){
        this.transactionService = transactionService;
    }


    @PostMapping //HTTP POST requests to add a new transaction
    public void addTransaction( @Validated @NonNull @RequestBody StockTransaction transaction){
        transactionService.addTransaction(transaction);
    }

    @GetMapping //HTTP GET requests to retrieve all transactions.
    public List<StockTransaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping(path = "{id}") //HTTP GET requests to retrieve a transaction by its ID.
    public StockTransaction getTransactionById(@PathVariable("id") UUID id) {
        return transactionService.getTransactionById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")//HTTP DELETE requests to delete a transaction by its ID.
    public void deleteTransactionById(@PathVariable("id") UUID id) {
        transactionService.deleteTransaction(id);
    }

    @PutMapping(path = "{id}")//HTTP PUT requests to update a transaction by its ID.
    public void updateCalculation(@PathVariable("id") UUID id, @Validated @NonNull @RequestBody StockTransaction transactionToUpdate ) {
        transactionService.updateTransaction(id, transactionToUpdate);
    }



    
}
