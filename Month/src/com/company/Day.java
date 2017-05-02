package com.company;

/**
 * Created by Laptop on 2017-01-12.
 */
public enum Day {
    MONDAY("Måndag","Bengan"),
    TUESDAY("Tisdag","Bengan"),
    WEDNESDAY("Onsdag","Bengan"),
    THURSDAY("Torsdag","Bengan"),
    FRIDAY("Fredag","Bengan"),
    SATURDAY("Lördag","Bengan"),
    SUNDAY("Söndag","Bengan");

    private final String swedish;
    private final String scullion;

    Day(String swedish, String scullion) {
        this.swedish = swedish;
        this.scullion = scullion;
    }
    public String getScullion(){
        return scullion;
    }
    public String getSwedish() {
        return swedish;
    }
}

