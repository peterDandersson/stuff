package com.company;

public class Main {

    public static void main(String[] args) {
        Par par = new Par("hej",4);
        System.out.println("" + par.first() + par.second());

        Par par2 = ParM(par);
        System.out.println("" + par2.first() + par2.second());

    }

    public static <A extends Par> A ParM(Par par){
        return (A) new Par(par.second(),par.first());
    }

    public static class Par <A, B>{
        A a;
        B b;

        Par(A a,B b){
            this.a = a;
            this.b = b;
        }

        public void setA(A a) {
            this.a = a;
        }

        public void setB(B b) {
            this.b = b;
        }

        public A first() {
            return a;
        }

        public B second() {
            return b;
        }
    }
}
