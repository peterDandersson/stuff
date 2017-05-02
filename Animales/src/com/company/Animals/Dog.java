package com.company.Animals;

/**
 * Created by Laptop on 2017-01-13.
 */
public class Dog extends Mammal implements Pet {

    @Override
    public String toString() {
        return "Dog";
    }

    @Override
    public void Feed(Prey prey) {
        System.out.println("Wof wof " + prey + " yummy!");

    }
}
