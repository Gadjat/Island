package ru.javarush.island.bulimov.islandSettings;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import ru.javarush.island.bulimov.entity.Organism;
import ru.javarush.island.bulimov.entity.animals.carnivores.Fox;

import java.net.URL;
import java.util.HashSet;

public class Setting {
    private static final HashSet<Organism> PROTOTYPES = new HashSet<Organism>(){};

    public Setting() {
        updateFromYaml();
    }

    public static final String SETTING_YAML = "setting.yaml";

    public static HashSet<Organism> getPROTOTYPES() {
        return PROTOTYPES;
    }

    private void updateFromYaml() {
        ObjectMapper mapper = new YAMLMapper();

        URL resource = Setting.class.getClassLoader().getResource(SETTING_YAML);
        try {
            PROTOTYPES.add(mapper.readValue(SETTING_YAML, Fox.class));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


//        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
//        ObjectReader readerForUpdating = mapper.readerForUpdating(this);
//        URL resource = Setting.class.getClassLoader().getResource(SETTING_YAML);
//        if (Objects.nonNull(resource)) {
//            try {
//                readerForUpdating.readValue(resource.openStream());
//            } catch (IOException e) {
//                throw new IslandRunException("Update From Yaml error " + e);
//            }
//        }
    }

    @Override
    public String toString() {
        return getPROTOTYPES().toString();
    }

    public static void main(String[] args) {
        Setting setting = new Setting();
        System.out.println(setting.toString());
    }
}
