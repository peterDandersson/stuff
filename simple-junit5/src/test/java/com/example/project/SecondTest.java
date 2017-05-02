package com.example.project;


import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SecondTest {

    private NrTwoClass nrTwoClass;

    @Before
    public void setUp(){
        System.out.println("setting up");
        nrTwoClass = new NrTwoClass(6);
        System.out.println("number = " + nrTwoClass.getNumber());
    }

    @Test
    public void CheckIfNumberIsSix(){
        assertEquals(6, nrTwoClass.getNumber());
        System.out.println("Checking If Number Is Six...");
    }

    @Test
    public void CheckSetterForNumberInNrTwoClass(){
        nrTwoClass.setNumber(4);
        assertEquals(4, nrTwoClass.getNumber());
        System.out.println("Checking Setter For Number In 'NrTwoClass'...");
    }
}
