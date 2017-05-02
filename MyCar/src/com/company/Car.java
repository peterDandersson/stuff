package com.company;

/**
 * Created by Laptop on 2017-01-12.
 */
public class Car {
    private final String brand;
    private final String model;
    private final int doors;

    public Car(String brand, String model, int doors){
        this.brand = brand;
        this.model = model;
        this.doors = doors;
    }

    @Override
    public String toString(){
        return brand+ " " + model +"," + " " + doors + " doors";
    }
}
