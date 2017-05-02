package com.company.Animals;

/**
 * Created by Laptop on 2017-01-13.
 */
public class Cat extends Mammal implements Pet{
    @Override
    public void Feed(Prey prey) {
        System.out.println("mjauu " + prey + " prrrrprr!");
    }
    @Override
    public String toString() {
        return "Cat";
    }
}
