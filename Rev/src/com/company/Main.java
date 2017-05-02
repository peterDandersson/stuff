package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String num = sc.nextLine();
/*        String newNum = "";

        for(int i = (num.length() - 1); i > -1 ; i--){
            newNum = newNum + num.substring(i,i+1);
        }*/
        System.out.print(new StringBuilder(num).reverse().toString());
    }
}
