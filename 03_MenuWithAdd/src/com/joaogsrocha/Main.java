package com.joaogsrocha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Main {

    private static ArrayList<String> names = new ArrayList<>(Arrays.asList("Geeks", "for", "Geeks"));

    private static String listNames() {
        var bld = new StringBuilder();
        Iterator<String> it = names.iterator();
        while(it.hasNext()) {
            bld.append(it.next());
            if(it.hasNext())
                bld.append(",");
        }
        var listOfNames = bld.toString();

        return "List of Names:" + listOfNames;
    }

    private static String addName() throws IOException {
        var bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("New Name to Add: ");
        String name;
        name = bufferedReader.readLine();
        names.add(name);
        var bld = new StringBuilder();
        bld.append("Names:" + names + "\n"+ "Added Name:"+ name);
        bld.append("\n ---------------------");
        return bld.toString();
    }

    private static String pickMenuOption(String option) throws IOException {
        switch (option){
            case "1":
                return listNames();
            case "2":
                return addName();
            default:
                return option;
        }
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);

        String option = "";
        do {
            System.out.println("1 - List Names \n" +
                               "2 - Add Name \n" +
                               "0 - Exit Program");
            option = br.readLine();
            System.out.println("Option Picked: " + option);
            System.out.println(pickMenuOption(option));
        }   while (Integer.parseInt(option) != 0);
            br.close();
        r.close();

    }
}
