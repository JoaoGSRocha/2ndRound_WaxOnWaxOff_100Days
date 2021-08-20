package com.joaogsrocha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);

        String name = "";
        while (!name.equals("stop")){
            System.out.println("Enter data:");
            name = br.readLine();
            System.out.println("data is:" + name);
        }
        br.close();
        r.close();
    }
}
