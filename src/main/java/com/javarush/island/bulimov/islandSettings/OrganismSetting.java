package com.javarush.island.bulimov.islandSettings;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.javarush.island.bulimov.entity.Organism;
import com.javarush.island.bulimov.entity.animals.carnivores.Wolf;
import com.javarush.island.bulimov.entity.animals.herbivores.Horse;
import com.javarush.island.bulimov.entity.plants.Plant;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

public class OrganismSetting {
    private static HashSet<Organism> animals = new HashSet<Organism>(15){};
    static{
        animals.add(new Wolf(50.0, 30, 3, 8,ThreadLocalRandom.current().nextDouble(4.0, 8.0)));
        animals.add(new Horse(400.0, 20, 4, 60,ThreadLocalRandom.current().nextDouble(30.0, 60.0)));
        animals.add(new Plant(1.0, 200));
    }

    public static HashSet<Organism> getAnimals() {
        return animals;
    }

    static String[] names = {
            "Wolf", "Boa", "Fox", "Bear", "Eagle",
            "Horse", "Deer", "Rabbit", "Mouse", "Goat", "Sheep", "Boar", "Buffalo", "Duck", "Caterpillar",
            "Plant",
    };

    static int[][] percent = {
            {0, 0, 0, 0, 0, 10, 15, 60, 80, 60, 70, 15, 10, 40, 0, 0},
            {0, 0, 15, 0, 0, 0, 0, 20, 40, 0, 0, 0, 0, 10, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 70, 90, 0, 0, 0, 0, 60, 40, 0},
            {0, 80, 0, 0, 0, 40, 80, 80, 90, 70, 70, 50, 20, 10, 0, 0},
            {0, 0, 10, 0, 0, 0, 0, 90, 90, 0, 0, 0, 0, 80, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 90, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 50, 0, 0, 0, 0, 0, 90, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 90, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    };

    public static String[] getNames() {
        return names;
    }

    public static int[][] getPercent() {
        return percent;
    }

    public static void main(String[] args) throws IOException {
        ObjectMapper yaml = new ObjectMapper(new YAMLFactory());
        yaml.enable(SerializationFeature.INDENT_OUTPUT);
        HashSet<Organism> animalsEatPercent = OrganismSetting.getAnimals();
        yaml.writeValue(new File("setting.yaml"), animalsEatPercent);
    }
}
