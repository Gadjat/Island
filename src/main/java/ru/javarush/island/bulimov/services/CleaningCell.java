package ru.javarush.island.bulimov.services;

import ru.javarush.island.bulimov.entity.islandSettings.OrganismSetting;
import ru.javarush.island.bulimov.islandMap.Cell;

public class CleaningCell {
    public static boolean deleteDead(Cell cell) {
        cell.getLock().lock();
        try{
            for (String name : OrganismSetting.getNames()) {
                cell.getAnimalsCell().get(name).removeIf(organism -> organism.weight<=0);
                return true;
            }

            return false;
        }
        finally {
            cell.getLock().unlock();
        }
    }
}
