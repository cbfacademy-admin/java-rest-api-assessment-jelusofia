package com.cbfacademy.apiassessment.model;

import java.util.UUID;

public class Calculator {
    private final UUID id; //transaction UUID
    private final String name; //
    private final int quantity; //
    // (need to check if int can be use din calcs with doubles)
    private final double buyingPrice;
    private final double sellingPrice;
    private final double comission;

    double profit;


    public Calculator(UUID id, String name, int quantity, double buyingPrice, double sellingPrice, double comission, double profit){
        this.id = id;
        this.name =name;
        this.quantity = quantity;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
        this.comission = comission;
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
    public Double getComission(){
        return comission;
    }
    public Double getProfit(){
        return profit;
    }




}
