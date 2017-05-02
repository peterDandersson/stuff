package com.company;

import java.lang.reflect.Method;

/**
 * Created by Laptop on 2017-01-19.
 */
public class DriverDemo {
    private Driver[] driverList;

    DriverDemo(Driver[] driverList){
        this.driverList = driverList;

        //Run the Driver methods
        CheckDriversCapabilities();
    }

    private void CheckDriversCapabilities(){
        if(driverList.length > 0){
            for (int i = 0; i < driverList.length; i++) {
                //Try to reflect methods
                try {
                    Method getCapabilitiesEx = driverList[i].getClass().getMethod("getCapabilitiesEx");
                    System.out.println(driverList[i].getClass().getTypeName() + ": " + getCapabilitiesEx.invoke(driverList[i]));
                } catch (Exception e){
                    try {
                        Method getCapabilities = driverList[i].getClass().getMethod("getCapabilities");
                        System.out.println(driverList[i].getClass().getTypeName() + ": " + getCapabilities.invoke(driverList[i]));
                    } catch (Exception b) {
                        System.err.print("An error message");
                    }
                }
            }
        }
    }
}
