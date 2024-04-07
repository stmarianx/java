package org.example;

import com.github.javafaker.Faker;

import java.util.*;

public class CarpoolSimulation {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        Faker faker = new Faker();
        Random random = new Random();
        List<String> destinations = new ArrayList<>();

        // Generăm
        for (int i = 0; i < 5; i++) {
            destinations.add(faker.country().capital());
        }

        // Populăm lista cu Driver și Passenger
        for (int i = 0; i < 20; i++) {
            String name = faker.name().fullName(); // Nume fals
            String destination = destinations.get(random.nextInt(destinations.size()));
            int age = 18 + random.nextInt(50); // Vârstă între 18 și 67

            if (random.nextBoolean()) {
                // Driver cu o rută care include destinația și încă una aleatorie
                List<String> route = new ArrayList<>(destinations);
                route.remove(destination); // Eliminăm destinația principală pentru a evita duplicarea
                // Selectăm random.nextInt(route.size()) destinații pentru ruta
                route = route.subList(0, 1 + random.nextInt(route.size()));
                route.add(destination); // Adăugăm destinația principală înapoi
                people.add(new Driver(name, destination, age, route));
            } else {
                people.add(new Passenger(name, destination, age));
            }
        }


        // Now use CarpoolService to compute the required information
        CarpoolService carpoolService = new CarpoolService(people);
/*
        // Get the list of all destinations drivers pass through
        Set<String> driverDestinations = carpoolService.computeDriverDestinations();
        System.out.println("All Driver Destinations: " + driverDestinations);

        // Get the map of destinations and the people who want to go there
        Map<String, List<Person>> destinationMap = carpoolService.mapDestinationsToPeople();
        destinationMap.forEach((dest, persons) -> {
            System.out.println("Destination: " + dest);
            persons.forEach(person -> System.out.println("\tPerson: " + person.getName()));
        });

         */

        // Match drivers with passengers using the CarpoolService
        Map<Driver, Passenger> matches = carpoolService.matchCarpool();

        matches.forEach((driver, passenger) -> {
            System.out.println("Driver: " + driver.getName() + " will take Passenger: " + passenger.getName());
        });


    }
}
