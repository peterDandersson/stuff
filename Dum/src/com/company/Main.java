package com.company;


public class Main {

    public static void main(String[] args) {
            if(args.length < 1){
                System.out.println("Saknas parameter för beräkning.");
            } else if(!isNumeric(args[0])){
                System.out.println("Felaktig parameter för beräkning.");
            } else {
                int r = Integer.parseInt(args[0]);
                System.out.println("Cirkelns area: " + area(r));
                System.out.println("Cirkelns omkrets: " + circumference(r));
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

    private static float area(float r) {
        return (float) (r * r * Math.PI);
    }

    private static float circumference (float r) {
        return (float) (r * 2 * Math.PI);
    }
}