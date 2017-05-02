package com.company;

/**
 * Created by Peter
 */

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        starCreator(20, "Börje", 500, 5).start();
        starCreator(40, "Lisa", 200, 6).start();
    }


    static Thread starCreator(int line, String name, long delay, long stop){
        LocalDateTime stopTime = LocalDateTime.now().plusSeconds(stop);

        Thread t1 = new Thread(() -> {
            StringBuilder sb = new StringBuilder(name + ": ");
            for(int i = 0; i < line; i++){
                sb.append("*");
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(sb);
                if(LocalDateTime.now().isAfter(stopTime)){
                    break;
                }
            }
        });

        return t1;
    }
}
