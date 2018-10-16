package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static Logger LOG = LogManager.getLogger(Config.class);

    public static Properties loadProperties(String propertyFile) {
        Properties config = new Properties();
        InputStream input;
        try {
            input = Config.class.getClassLoader().getResourceAsStream(propertyFile);
            config.load(input);
        } catch (Exception e) {
            LOG.info("File not found");
        }
        return config;
    }
}
