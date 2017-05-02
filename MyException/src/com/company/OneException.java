package com.company;

import java.io.IOException;

/**
 * Created by Peter
 */

public class OneException {

        public static void main(String[] args) {
        try {
            inputQ();
        } catch (MyException e){
            System.err.print(e.getMessage());
        }
    }

    public static void inputQ() throws MyException {
        int input;
        System.out.println("type: 'q' to quit");
        while (true) {

            try {
                input = System.in.read();
            } catch (IOException e){
                throw new MyException(e.getMessage());
            }
            if(input == 'q' || input == 'Q'){
                throw new MyException("My exception is the best...");
            }

        }
    }

    public static class MyException extends Exception{

        public MyException() {
        }

        public MyException(String s) {
            super(s);
        }
    }
}
