package com.javarush.island.bulimov.islandSettings;

import com.javarush.island.bulimov.abstractions.Organism;
import com.javarush.island.bulimov.entity.animals.carnivores.Wolf;

import java.util.HashMap;
import java.util.Set;

public class OrganismSetting {
    private HashMap<Organism, Limits> animals = new HashMap<>();

    private OrganismSetting(){
        animals.put(Wolf);
    }
}
