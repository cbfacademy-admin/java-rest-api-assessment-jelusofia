package com.cbfacademy.apiassessment.model;

import java.util.UUID;

public class Calculator {
    private final UUID id; //transaction UUID
    private final String name; //
    private final int numberOfShares; //
    // (need to check if int can be use din calcs with doubles)
    private final double buyingPrice;
    private final double sellingPrice;
    private final double comission;

    double profit;


    public Calculator(UUID id, String name, int numberOfShares, double buyingPrice, double sellingPrice, double comission){
        this.id = id;
        this.name =name;
        this.numberOfShares = numberOfShares;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
        this.comission = comission;
    }

    public UUID getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getNumberOfShares(){
        return numberOfShares;
    }
    public Double buyingPrice(){
        return buyingPrice;
    }
    public Double sellingPrice(){
        return sellingPrice;
    }
    public Double comission(){
        return comission;
    }
    public Double profit(){
        return profit;
    }




}
