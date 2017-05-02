package com.company.Animals;

/**
 * Created by Laptop on 2017-01-13.
 */
public class Falcon extends Bird implements Pet {
    @Override
    public void Feed(Prey prey) {
        System.out.println("wiii " + prey);
    }

    @Override
    public String toString() {
        return "Falcon{}";
    }
}
