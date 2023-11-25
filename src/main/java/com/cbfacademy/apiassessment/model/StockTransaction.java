//packages
package com.cbfacademy.apiassessment.model;
//imports
import java.util.UUID;

//This class

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
        this.profit = calculateProfit();
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

    public double calculateProfit() {
        return (sellingPrice * quantity) - (buyingPrice * quantity) - commission;
    }

    //For toString method to use in testing the merge sort algo
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
