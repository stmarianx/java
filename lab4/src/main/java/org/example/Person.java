package org.example;

import java.util.*;

class Person {
    String name;
    String destination;

    int age;

    Person(String name, String destination, int age) {
        this.name = name;
        this.destination = destination;
        this.age = age;
    }
    // Getter pentru destination
    public String getDestination() {
        return destination;
    }

    // Presupunem existența getter-ului pentru name pentru a completa exemplul
    public String getName() {
        return name;
    }
}