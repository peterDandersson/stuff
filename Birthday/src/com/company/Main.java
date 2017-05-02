package com.company;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        if(args.length < 1){
            System.out.println("Saknas parameter för beräkning.");
        } else if(!isNumeric(args[0].substring(0,6))){
            System.out.println("Felaktig parameter för beräkning.");
        } else {
            LocalDateTime a = LocalDateTime.now();
            int currentMonth = a.getMonth().getValue();
            int currentDay = a.getDayOfMonth();
            int birthMonth = Integer.parseInt(args[0].substring(2,4));
            int birthDay = Integer.parseInt(args[0].substring(4,6));

            if(currentDay == birthDay && currentMonth == birthMonth){
                System.out.println("Grattis!");
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
