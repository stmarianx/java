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
}
