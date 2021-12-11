package com.joaogsrocha;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> al = new ArrayList<>(Arrays.asList("Test", "Test2", "Test3", "Test4"));
        al.add("new");

        for (String el : al) {
            System.out.print(el+ " ");
        }

    }
}
