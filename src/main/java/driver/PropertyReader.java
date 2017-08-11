package driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by lisboalien on 14/08/2017
 * The PropertyReader class is responsible of managing the project properties inside config.properties file
 */
public class PropertyReader {
    private Properties properties = new Properties();
    private InputStream inputStream = null;

    /**
     * PropertyReader constructor.
     * It calls loadProperties() method
     */
    public PropertyReader() {
        loadProperties();
    }

    /**
     * Method that load all properties in config.properties file and put it in properties variable
     */
    private void loadProperties() {
        try {
            inputStream = new FileInputStream("src/config.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method that reads the properties that are loaded in properties variable
     *
     * @param key (The key you want to search in properties variable)
     * @return (Returns the String value of the property you asked)
     */
    public String readProperty(String key) {
        return properties.getProperty(key);
    }
}
