package com.company;

public class Main {

    public static void main(String[] args) {

        Driver[] dList = {new MonsterDriver(),new StandardDriver()};

        //Print out capabilities
        new DriverDemo(dList);
    }
}
