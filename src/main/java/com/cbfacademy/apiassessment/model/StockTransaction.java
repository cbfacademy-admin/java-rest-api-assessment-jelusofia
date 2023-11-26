//packages
package com.cbfacademy.apiassessment.model;
//imports
import java.util.UUID;

//This class is a model class for this project, it models the Stock Transaction use in the calculation of Profit and Loss
//Future development: add data validation

public class StockTransaction {
    private final UUID id; //transaction UUID
    private final String name; //name of stocks
    private final int quantity; //number of shares = quantity
    private final double buyingPrice; // buying price of stocks
    private final double sellingPrice; // selling price of stocks
    private final double commission; //broker's commission
    double profit; //profit/loss calculation

    //Constructor
    public StockTransaction(UUID id, String name, int quantity, double buyingPrice, double sellingPrice, double commission, double profit){
        this.id = id;
        this.name =name;
        this.quantity = quantity;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
        this.commission = commission;
        this.profit = calculateProfit();
    }

    //Getters
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

    //Profit Calculation 
    public double calculateProfit() {
        return (sellingPrice * quantity) - (buyingPrice * quantity) - commission;
    }

    //toString method to use in testing the merge sort algorithm in the MergeSortAlgo.java
    @Override
    public String toString() {
        return "StockTransaction{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", buyingPrice=" + buyingPrice +
                ", sellingPrice=" + sellingPrice +
                ", commission=" + commission +
                ", profit=" + profit +
                '}';
    }

}
