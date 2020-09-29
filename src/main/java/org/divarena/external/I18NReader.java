package org.divarena.external;

import lombok.Getter;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class I18NReader {

    private final Properties properties;

    public I18NReader() throws Exception {
        this.properties = new Properties();
        properties.load(new FileInputStream(new File("./data/texts_fr.properties")));
    }

    public String getString(DataType type, String key) {
        return new String(properties.getProperty(type.getPath() + "." + type.getId() + "." + key).getBytes(), StandardCharsets.UTF_8);
    }

    public enum DataType {
        FIGHTER_CARD_NAME("content", 1),
        FIGHTER_CARD_DESCRIPTION("content", 2),
        SPELL_NAME("content", 3),
        SPELL_DESCRIPTION("content", 4),
        COACH_CARD_NAME("content", 23),
        COACH_CARD_DESCRIPTION("content", 24);

        @Getter
        private final String path;
        @Getter
        private final int id;

        DataType(String path, int id) {
            this.path = path;
            this.id = id;
        }
    }
}
