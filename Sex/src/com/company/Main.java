package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean correctInput = false;

        System.out.println("Skriv in ditt personnummer:");
        while (!correctInput) {
            String input = sc.nextLine();
            if (isNumeric(input) && input.length() == 10){
                if (((Integer.parseInt(input.substring(8, 9))) & 1) == 0) {
                    System.out.println("Kvinna");
                } else {
                    System.out.println("Dude!");
                }
                correctInput = true;
            } else {
                System.out.println("Det ska anges som 10 siffror");
            }
        }
    }


        public static boolean isNumeric(String str)
        {
            try
            {
                double d = Double.parseDouble(str);
            }
            catch(NumberFormatException nfe)
            {
                return false;
            }
            return true;
        }
}
