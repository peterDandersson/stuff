package com.company;

import java.util.Random;

/**
 * Created by Laptop on 2017-01-27.
 */
public class Die {
    private int value;

    public int getValue() {
        return value;
    }

    public int roll(){
        value = new Random().nextInt(6) + 1;
        return value;
    }
}
