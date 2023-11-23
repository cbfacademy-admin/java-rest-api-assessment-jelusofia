package com.cbfacademy.apiassessment.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import com.cbfacademy.apiassessment.model.StockTransaction;

public class MergeSortAlgo {
    

    public static void mergeSortAlgo(List<StockTransaction> transactions){
        if (transactions.size() <= 1) {
            return;
        }

        int middle = transactions.size()/2;
        List<StockTransaction> left = transactions.subList(0, middle);
        List<StockTransaction> right = transactions.subList(middle,transactions.size());

        mergeSortAlgo(left);
        mergeSortAlgo(right);

        merge(transactions, left, right);
    }

    private static void merge(List<StockTransaction> transactions, List<StockTransaction> left, List<StockTransaction> right){
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).getProfit() < right.get(j).getProfit() ||
               (left.get(i).getProfit() == right.get(j).getProfit() && 
                left.get(i).getId().compareTo(right.get(j).getId()) < 0)) {
                transactions.set(k++, left.get(i++));
            } else {
                transactions.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) {
            transactions.set(k++, left.get(i++));
        }

        while (j < right.size()) {
            transactions.set(k++, right.get(j++));
        }

    }
    public static void main(String[]args){ 
        List<StockTransaction> transactions = new ArrayList<>(Arrays.asList(
            new StockTransaction(UUID.randomUUID(), "Example1", 25, 100.0, 120.0, 5.0, 20),
            new StockTransaction(UUID.randomUUID(), "Example2", 10, 100.0, 120.0, 5.0, 0.0),
            new StockTransaction(UUID.randomUUID(), "Example3", 15, 100.0, 120.0, 5.0, 2)
        ));

        System.out.println("Before sorting:");
        transactions.forEach(System.out::println);

        mergeSortAlgo(transactions);

        System.out.println("After sorting:");
        transactions.forEach(System.out::println);
    }
}
