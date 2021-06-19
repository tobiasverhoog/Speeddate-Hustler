package com.Verhoog;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class GsonWriterReader {

    public static void writeJSON(Person person) throws IOException {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        FileWriter writer = new FileWriter(person.getName() + ".json");
        writer.write(gson.toJson(person));
        writer.close();
    }

    public static Person readJSON(String name) throws FileNotFoundException {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader(name + ".json"));

        return gson.fromJson(bufferedReader, Person.class);
    }
}
