package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CarpoolMatcher {
    List<Driver> drivers;
    List<Passenger> passengers;

    CarpoolMatcher(List<Driver> drivers, List<Passenger> passengers) {
        this.drivers = drivers;
        this.passengers = passengers;
    }

    Map<Driver, Passenger> matchDriversAndPassengers() {
        Map<Driver, Passenger> matches = new HashMap<>();

        for (Driver driver : drivers) {
            for (Passenger passenger : passengers) {
                if (driver.canDriveTo(passenger.destination) && !matches.containsKey(driver)) {
                    matches.put(driver, passenger);
                    break; // Match found, move to the next driver
                }
            }
        }

        return matches;
    }
}