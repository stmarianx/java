package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class CarpoolService {
    private List<Person> people;

    public CarpoolService(List<Person> people) {
        this.people = people;
    }

    // Computes a list of all unique destinations that drivers pass through
    public Set<String> computeDriverDestinations() {
        return people.stream()
                .filter(p -> p instanceof Driver)
                .map(p -> (Driver) p)
                .flatMap(driver -> driver.route.stream())
                .collect(Collectors.toSet());
    }

    // Computes a map of destinations and the list of people who want to go there
    public Map<String, List<Person>> mapDestinationsToPeople() {
        return people.stream()
                .collect(Collectors.groupingBy(Person::getDestination));
    }

    // The greedy algorithm
    public Map<Driver, Passenger> matchCarpool() {
        List<Driver> drivers = people.stream()
                .filter(p -> p instanceof Driver)
                .map(p -> (Driver) p)
                .collect(Collectors.toList());
        List<Passenger> passengers = people.stream()
                .filter(p -> p instanceof Passenger)
                .map(p -> (Passenger) p)
                .collect(Collectors.toList());

        Map<Driver, Passenger> matches = new HashMap<>(); // A map to hold the matches.

        // Iterate through the list of drivers.
        for (Driver driver : drivers) {
            // Iterate through the list of destinations for the current driver.
            for (String destination : driver.getDestinations()) {
                // Iterate through the list of passengers to find a match.
                for (Passenger passenger : passengers) {
                    if (destination.equals(passenger.getDestination()) && !matches.containsValue(passenger)) {
                        matches.put(driver, passenger);
                        break; // Break the loop once a passenger is found.
                    }
                }
                // If a match was found for this driver, break.
                if (matches.containsKey(driver)) {
                    break;
                }
            }
        }

        return matches; // Return the map of matched driver-passenger pairs.
    }
}
