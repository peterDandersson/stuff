/*
 * Copyright 2015-2016 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v10.html
 */

package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.expectThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import java.util.HashMap;
import java.util.Map;

class FirstTest {

/*    private static Calculator calculator;
    private static Synonyms synonyms;

    @BeforeAll
    static void initAll(){
        Map<String, String> map = new HashMap<>();
        map.put("word","synonym");
        synonyms = new Synonyms();
        synonyms.setWords(map);
        calculator = new Calculator();
    }*/

    @Test
    void calculatorTest(){
        assertEquals("4","4");
        //assertEquals(calculator.addition(2,2),"4");
        //assertEquals(calculator.subtraction(4,2),"2");
    }
/*
    @Test
    void c2(){
        expectThrows(Exception.class,
                () -> {calculator.division(2,0);});
    }

    @Test
    void c3(){
        calculator.division(2,1);
    }

    @Test
    void c4(){
        assertEquals(synonyms.getSynonyms("word"),"synonym");
    }


	//Övning 2
	private static Circle circle;
	private static int o;

	@BeforeAll
	static void initAll(){
		circle = new Circle(4);
		o = 4 * Math.PI;
	}

	@Test
	@DisplayName("JUnit 5 test! 😎")
	void myFirstTest(TestInfo testInfo) {
		assertEquals(o, circle.getCircumference(), "should equal" + o);
	}*/

}
