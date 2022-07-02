package ru.javarush.island.bulimov.view;

import ru.javarush.island.bulimov.entity.Organism;
import ru.javarush.island.bulimov.settings.OrganismSetting;
import ru.javarush.island.bulimov.islandMap.Cell;
import ru.javarush.island.bulimov.islandMap.Island;

public class ConsoleView {

    public  void viewShow(){
        System.out.println("****************************** Выполняется такт *********************************");
        String iconAnimalMax = "";
        int max = 0;
        for (Cell[] row : Island.getAnimalMap()) {
            for (Cell cell : row) {
                
                for (String name : OrganismSetting.getNames()) {
                    if(cell.getAnimalsCell().get(name)!= null && max <= cell.getAnimalsCell().get(name).size()){
                        max = cell.getAnimalsCell().get(name).size();
                        for (Organism organism : cell.getAnimalsCell().get(name)) {
                            iconAnimalMax = organism.icon;
                            break;
                        }
                    }
                }
                System.out.print(iconAnimalMax + " " + max + "|");
            }
            System.out.println();
        }
        System.out.println("****************************** Такт окончен *********************************");
    }
}
