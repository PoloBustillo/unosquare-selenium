package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

    Properties prop = new Properties();
    InputStream input = null;

    public Properties load() {
        try {

            input = new FileInputStream("src/test/resources/config.properties");
            prop.load(input);
            System.out.println(prop.getProperty("url"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop;
    }

}
