package ru.javarush.island.bulimov.entity.islandSettings;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import ru.javarush.island.bulimov.entity.Organism;
import ru.javarush.island.bulimov.entity.animals.carnivores.*;
import ru.javarush.island.bulimov.entity.animals.herbivores.*;
import ru.javarush.island.bulimov.entity.plants.Plant;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;

public class OrganismSetting {
    private final static HashSet<Organism> animals = new HashSet<>(){};
    static{
        animals.add(new Wolf(50.0, 30, 3, 8,4.0));
        animals.add(new Boa(15, 30, 1, 3,1.5));
        animals.add(new Fox(8, 30, 2, 2,1.0));
        animals.add(new Bear(500, 5, 2, 80,40.0));
        animals.add(new Eagle(6, 20, 3, 1,0.5));

        animals.add(new Horse(400.0, 20, 4, 60,30.0));
        animals.add(new Deer(300, 20, 4, 50,25.0));
        animals.add(new Rabbit(2, 150, 2, 0.45,0.15));
        animals.add(new Mouse(0.05, 500, 1, 0.01,0.005));
        animals.add(new Goat(60, 140, 3, 10,5.0));
        animals.add(new Sheep(70, 140, 3, 15,7.0));
        animals.add(new Boar(400, 50, 2, 50,25.0));
        animals.add(new Buffalo(700, 10, 3, 100,50.0));
        animals.add(new Duck(1, 200, 4, 0.15,0.5));
        animals.add(new Caterpillar(0.01, 1000, 0, 0,0));

        animals.add(new Plant(1.0, 200, 0));
    }



    public static HashSet<Organism> getAnimals() {
        return animals;
    }





    private static final String[] names = {
            "Wolf", "Boa", "Fox", "Bear", "Eagle",
            "Horse", "Deer", "Rabbit", "Mouse", "Goat", "Sheep", "Boar", "Buffalo", "Duck", "Caterpillar",
            "Plant",
    };

    private static final int[][] percent = {
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
