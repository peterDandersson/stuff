package com.company.Animals;

/**
 * Created by Laptop on 2017-01-13.
 */
public class Python extends Reptile implements Pet {
    @Override
    public void Feed(Prey prey) {
        System.out.println(prey + " ...delicioussssssssss");
    }

    @Override
    public String toString() {
        return "Python";
    }
}
