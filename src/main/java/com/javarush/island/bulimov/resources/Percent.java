package com.javarush.island.bulimov.resources;

public class Percent {
    private String name;
    private Integer percent;

    public Percent(String name, Integer percent) {
        this.name = name;
        this.percent = percent;
    }

    public String getName() {
        return name;
    }

    public Integer getPercent() {
        return percent;
    }
}
