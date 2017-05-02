package com.company.Animals;

/**
 * Created by Laptop on 2017-01-13.
 */
public class Rabbit extends Mammal implements Pet, Prey {
    @Override
    public void Feed(Prey prey) {
        System.out.println("mmmm " + prey + " yummy!");
    }

    @Override
    public String toString() {
        return "Rabbit";
    }
}
