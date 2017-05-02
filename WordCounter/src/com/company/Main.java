package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static Map<String, Integer> map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        map = new HashMap<>();

        System.out.println("Hej, skriv in ord. avsluta genom att skriva q");

        while (true) {
            String newWord = sc.next();

            if(newWord.charAt(0) == 'q'){ System.exit(0);}
            if(Letters(newWord)){ addWord(newWord); }

            Set set = map.entrySet();
            set.forEach(a -> System.out.println(a));
        }
    }

    static boolean Letters (String word) {
        for (int i = 0; i < word.length(); i++){
            if(!Character.isLetter(word.charAt(i))){
                System.out.println("Det får bara vara bokstäver...");
                return false;
            }
        }
        return true;
    }

    static void addWord(String word) {
        Integer v = (null != map.get(word)) ? map.get(word) : 0;
        v++;
        map.put(word,v);
    }
}