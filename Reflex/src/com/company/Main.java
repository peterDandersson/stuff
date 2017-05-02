package com.company;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        try {
            A a = (A) Class.forName("com.company.A").newInstance();
            Method b = a.getClass().getMethod("b");
            b.invoke(a);

            ElClass elClass = new ElClass(((Ref) Class.forName("com.company.R1").newInstance()));
            ElClass elClass2 = new ElClass(((Ref) Class.forName("com.company.R2").newInstance()));
        } catch (Exception e) {
            System.err.print(e.getMessage());
        }
    }
}
