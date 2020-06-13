package edu.kis.powp.jobs2d.features;

import edu.kis.powp.observer.Subscriber;

public class DriverInfoChangeObserver implements Subscriber {

    public void update() {
        DriverFeature.updateDriverInfo();
    }

    public String toString() {
        return "Driver Feature Change Observer";
    }
}