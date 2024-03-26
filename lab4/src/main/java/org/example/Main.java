package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        Random random = new Random();
        List<String> destinations = Arrays.asList("City A", "City B", "City C", "City D");

        // Populate
        for (int i = 0; i < 20; i++) {
            String destination = destinations.get(random.nextInt(destinations.size()));
            int age = 18 + random.nextInt(50); // Random age
            if (random.nextBoolean()) {
                // each driver has a random route that includes the destination and one other
                List<String> route = new ArrayList<>(destinations);
                Collections.shuffle(route);
                route = route.stream().limit(2).collect(Collectors.toList()); // Limit to 2
                if (!route.contains(destination)) route.add(destination);
                people.add(new Driver("Driver " + i, destination, age, route));
            } else {
                people.add(new Passenger("Passenger " + i, destination, age));
            }
        }

        // Extract and sort drivers by age
        LinkedList<Driver> sortedDrivers = people.stream()
                .filter(p -> p instanceof Driver)
                .map(p -> (Driver) p)   // Cast to Driver
                .sorted(Comparator.comparingInt(driver -> driver.age))
                .collect(Collectors.toCollection(LinkedList::new)); // Collecting directly into a LinkedList

        // Printing sorted drivers by age
        System.out.println("Drivers sorted by age:");
        sortedDrivers.forEach(driver -> System.out.println(driver.name + ", Age: " + driver.age + ", Going to: " + driver.destination));



        Set<Passenger> passengersSortedByName = new TreeSet<>(Comparator.comparing(passenger -> passenger.name));

        people.stream()
                .filter(p -> p instanceof Passenger)
                .map(p -> (Passenger) p)
                .forEach(passengersSortedByName::add);

        // Printing the sorted passengers
        System.out.println("Passengers sorted by name:");
        passengersSortedByName.forEach(passenger -> System.out.println(passenger.name + ", Age: " + passenger.age + ", Going to: " + passenger.destination));

        /*
        List<Passenger> passengers = people.stream()
                .filter(p -> p instanceof Passenger)
                .map(p -> (Passenger) p)
                .collect(Collectors.toList());

        System.out.println("\nPassengers:");
        passengers.forEach(passenger -> System.out.println(passenger.name + ", Age: " + passenger.age + ", Going to: " + passenger.destination));

         */
    }
}
