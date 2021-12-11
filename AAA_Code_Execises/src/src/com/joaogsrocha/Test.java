package com.joaogsrocha;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<Integer> stockpairs = new ArrayList<Integer>();
        stockpairs.add(5);
        stockpairs.add(7);
        stockpairs.add(9);
        stockpairs.add(13);
        stockpairs.add(11);
        stockpairs.add(6);
        stockpairs.add(6);
        stockpairs.add(3);
        stockpairs.add(3);
        Test.stockPairs(stockpairs, 12);
    }

    public static int stockPairs(List<Integer> stockpairs,long target) {
        int count=0;
        int[] arr = stockpairs.stream().mapToInt(i -> i).toArray();
        Map<Integer,Integer> keys= new HashMap<Integer,Integer>();
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[i]+arr[j]==target) {
                    if(!keys.containsKey(arr[i]) && !keys.containsKey(arr[j])){
                        count++;
                        keys.put(arr[i], arr[j]);
                        keys.put(arr[j], arr[i]);
                        System.out.println(arr[i] +": "+arr[j]);
                    }
                }
            }
        }
        return count;
    }
}


