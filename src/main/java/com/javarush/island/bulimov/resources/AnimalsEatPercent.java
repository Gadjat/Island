package com.javarush.island.bulimov.resources;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class AnimalsEatPercent {

    private static AnimalsEatPercent instance;
    private static HashMap<String, HashSet<Percent>> eatPercent = new HashMap<>(15){{
        eatPercent.put("Wolf", new HashSet<>((Collection) new Percent("Deer", 10)));

    }};



    private AnimalsEatPercent(){
    }

    public static AnimalsEatPercent getInstance() {
        if(instance == null){
            instance = new AnimalsEatPercent();
        }
        return instance;
    }

    public HashMap<String, HashSet<Percent>> getEatPercent() {
        return eatPercent;
    }
}
