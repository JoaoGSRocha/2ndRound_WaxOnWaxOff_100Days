package com.joaogsrocha;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Integer> list =
                new ArrayList<>(List.of(5, 7, 9, 13, 11, 6, 6, 3, 3));
        int target = 12;

        HashSet<String> set=new HashSet(Arrays.asList("test", "test2"));
        HashSet<String> set2=new HashSet(Arrays.asList("test2", "test"));

        for (Object obj:set)
            if (set2.contains(obj))
                System.out.println("Match - "+ obj);

        System.out.println("List");


        Set<String> set1_ = new HashSet<>();

        set1_.add("Hello");
        set1_.add("Java Developer");
        set1_.add("Welcome");
        set1_.add("To");
        set1_.add("JavaProgramTo.com");


        Set<String> set2_ = new HashSet<>();

        set2_.add("Hello");
        set2_.add("Java Developer");
        set2_.add("Welcome");
        set2_.add("To");
        set2_.add("JavaProgramTo.com");

        boolean isEquals = set1_.equals(set2_);

        System.out.println("Is set 1 and set 2 equal ? : "+isEquals);
    /*    stockPairs(list, target);*/

        String a = "1+5*2-4";
        System.out.println(a);
        String[] operator = a.split("[0-9]+");
        String[] digits = a.split("[+-\\/*]");

        final int[] index = {0};
        int reduced = Stream.of(digits)
                .mapToInt(Integer::parseInt)
                .reduce(0, (int t, int u) ->
                {
                    int result = Integer.parseInt(digits[0]);
                    int i = index[0];
                    if (operator[i].equals("+")) { result = t + u; }
                    else if (operator[i].equals("/")) { result = t / u; }
                    else if (operator[i].equals("*")) { result = t * u; }
                    else if (operator[i].equals("-")) { result = t - u; }
                    index[0]++;
                    return result;
                });

        System.out.println(reduced);
    }

    public static int stockPairs(List<Integer> stocksProfit, long target) {
        Set targetSet = Set.copyOf(stocksProfit);

        HashSet<Set<Integer>> pairs = new HashSet<>();
        HashSet<Integer> pair = new HashSet<>();
        for(int i =0; i<=targetSet.size(); i++) {
            final int value = stocksProfit.get(i);
            for (int el : stocksProfit) {
                if(value + el == target) {
                    //PRITNLNS
                    System.out.print(el + " " + stocksProfit.get(i));
                    System.out.println("");

                    //SETTING THE NEW PAIR that give the TOTAL of 12

                    //COMPARISONS
                    if(pairs.size() == 0) {
                        pair.add(value);
                        pair.add(el);
                        pairs.add(pair);
                        continue;
                    }
                    final int[] countMatch = {0};
                    Set<Set<Integer>> newPairs = pairs.stream()
                            .filter(x -> {
                                x.stream().filter(y -> {
                                    if (value != y)
                                        return true;
                                    return false;
                                });
                                return true;
                            })
                            .collect(Collectors.toSet());
                    ;
                    System.out.println(newPairs);
/*                    if(newSet.stream().anyMatch(pair => );
                    if(newSet.contains(new Integer[] {stocksProfit.get(i), el}))
                        break;
                    newSet.add(pair);*/
                }
            }
        }


        return 1;
    }
}