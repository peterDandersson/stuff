package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
            List<String> list = new ArrayList<>();
            Scanner sc = new Scanner(System.in);

            while (list.size() < 10){
                    list.add(sc.next());
                    System.out.println(Collections.frequency(list, list.get(list.size()-1)));
            }


    }
}
