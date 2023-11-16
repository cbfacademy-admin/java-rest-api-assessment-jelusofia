package com.cbfacademy.apiassessment.model;

import java.util.UUID;
/*ToDo's:
- add validation
- add comments
*/

public class StockTransaction {
    private final UUID id; //transaction UUID
    private final String name; //
    private final int quantity; //
    private final double buyingPrice;
    private final double sellingPrice;
    private final double commission;

    double profit;


    public StockTransaction(UUID id, String name, int quantity, double buyingPrice, double sellingPrice, double commission, double profit){
        this.id = id;
        this.name =name;
        this.quantity = quantity;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
        this.commission = commission;
        this.profit = profit;
    }

    public UUID getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getQuantity(){
        return quantity;
    }
    public Double getBuyingPrice(){
        return buyingPrice;
    }
    public Double getSellingPrice(){
        return sellingPrice;
    }
    public Double getCommission(){
        return commission;
    }
    public Double getProfit(){
        return profit;
    }




}
