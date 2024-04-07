package org.example;

import java.util.List;

class Driver extends Person {
    List<String> route; // Assuming this is a list of destination names

    Driver(String name, String destination, int age, List<String> route) {
        super(name, destination, age);
        this.route = route;
    }

    boolean canDriveTo(String destination) {
        return route.contains(destination);
    }

    public List<String> getDestinations() {
        return route; // Return the route list
    }
}