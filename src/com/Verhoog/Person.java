package com.Verhoog;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Person implements Serializable {
    private String name;
    private ArrayList<String> history = new ArrayList<>();
    private transient boolean hasMatch;

    public Person(String name) {
        this.name = name;
    }

    public void addPersonToHistory(String name) {
        history.add(name);
    }

    public String getName() {
        return name;
    }

    public String findMatch(ArrayList<Person> list) {
        if (this.hasMatch) {
            System.out.println(this.name + " heeft al een match: " + this.history.get(this.history.size() - 1));
            return this.history.get(this.history.size() - 1);
        }

        for (int i = 0; i < 100; i++) {
            Random r = new Random();
            int randomNumber = r.nextInt((list.size()));
            Person possibleMatch = list.get(randomNumber);
            System.out.println("Probeer een match te vinden tussen " + this.name + " en " + possibleMatch.name);
            if (possibleMatch.name.equals(this.name)) {
                System.out.println(possibleMatch.name + " is dezelfde als " + this.name);
                continue;
            }

            if (this.history.contains(possibleMatch.getName())) {
                System.out.println("Historie van " + this.name + ": " + this.history + " bevat " + possibleMatch.name);
                continue;
            }

            if (possibleMatch.hasMatch) {
                System.out.println(possibleMatch.name + " heeft al een match");
                continue;
            }
            this.hasMatch = true;
            possibleMatch.hasMatch = true;
            this.history.add(possibleMatch.name);
            possibleMatch.history.add(this.name);
            return possibleMatch.name;

        }
        return "Geen match gevonden";

    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", history=" + history +
                ", hasMatch=" + hasMatch +
                '}';
    }

}
