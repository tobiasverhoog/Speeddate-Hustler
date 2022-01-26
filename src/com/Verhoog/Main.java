package com.Verhoog;

import java.io.IOException;
import java.util.ArrayList;

import static com.Verhoog.GsonWriterReader.readJSON;
import static com.Verhoog.GsonWriterReader.writeJSON;

public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList<Person> list = new ArrayList<>();
        String[] names = {"Bert", "Tobias", "Jurgen", "Marco", "Wessel", "Rick", "Rowald", "Pieter",
                "Brigitte", "Menno", "Silvio", "Andre", "Ollie", "Donja", "Eric", "Faroek",
                "Gerard", "Jasper", "Matthias", "Remo"};

//        Lees alle json bestanden, maak er objecten van en zet ze in een list
        for (String name : names) {
            list.add(readJSON(name));
        }

//        Print ter controle de inhoud van ieder object person
        for (Person person : list) {
            System.out.println(person);
        }


//        Koppel ieder persoon aan een ander en zet de koppels in list matches
        ArrayList<String> matches = new ArrayList<>();
        for (Person person : list) {
            String match = person.getName() + " <---> " + person.findMatch(list);
            matches.add(match);
            System.out.println(match);
        }

//        Print alle koppels nog een keer voor de duidelijkheid
        System.out.println();
        System.out.println("++++++++++ Alle matches van deze maand ++++++++++");
        for (String match : matches) {
            System.out.println(match);
        }
        System.out.println();

//        Schrijf de bijgewerkte personen weg in json bestanden
        for (Person person : list) {
            System.out.println(person);
            writeJSON(person);
        }

    }


}
