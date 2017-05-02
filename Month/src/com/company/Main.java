package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Vem diskar i dag?");
        System.out.println("Välj en veckodag genom att mata in dagens siffra.");


        int index = 1;
        for (Day d : Day.values()){
            System.out.println(index++ + " " + d.getSwedish());
        }

        final int num;
        num = sc.nextInt();
        ScullionOfTheDay(num);
    }

    public static void ScullionOfTheDay(int dayNum) {
        Day day;
        switch (dayNum) {
            case 1:
                day = Day.MONDAY;
                System.out.println(day.getSwedish() + " diskar: " + day.getScullion());
                break;
            case 2:
                day = Day.TUESDAY;
                System.out.println(day.getSwedish() + " diskar: " + day.getScullion());
                break;
            case 3:
                day = Day.WEDNESDAY;
                System.out.println(day.getSwedish() + " diskar: " + day.getScullion());
                break;
            case 4:
                day = Day.THURSDAY;
                System.out.println(day.getSwedish() + " diskar: " + day.getScullion());
                break;
            case 5:
                day = Day.FRIDAY;
                System.out.println(day.getSwedish() + " diskar: " + day.getScullion());
                break;
            case 6:
                day = Day.SATURDAY;
                System.out.println(day.getSwedish() + " diskar: " + day.getScullion());
                break;
            case 7:
                day = Day.SUNDAY;
                System.out.println(day.getSwedish() + " diskar: " + day.getScullion());
                break;

            default:
                System.out.println("Det är alltid Bengan som diskar!");
                break;
        }
    }
}