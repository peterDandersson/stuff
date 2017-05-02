package com.company.MainP;

import com.company.Animals.*;

public class Main {

    public static void main(String[] args) {
	    Animal[] animals = {new Bird(), new Mammal(), new Reptile(), new Mammal(), new Bird()};

        for (Animal a : animals){
            System.out.println(a.sound());
        }

        Pet[] pets = {new Cat(), new Python(), new Dog(), new Falcon(), new Rabbit()};
        Prey[] food = {new Mouse(), new Rabbit(), new Cow(), new Bluebird(), new Cow()};

        int index = 0;
        for (Pet p : pets) {
            p.Feed(food[index]);
            index++;
        }
    }
}
