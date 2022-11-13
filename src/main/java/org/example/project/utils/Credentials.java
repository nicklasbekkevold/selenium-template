package org.example.project.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class Credentials {

    public static final String USERNAME;
    public static final String PASSWORD;

    static {
        Properties properties = getProperties();
        USERNAME = properties.getProperty("username", "username");
        PASSWORD = properties.getProperty("password", "password");
    }

    private Credentials() {
    }

    private static Properties getProperties() {
        Properties properties = new Properties();
        try (InputStream input = Credentials.class.getClassLoader().getResourceAsStream("credentials.properties")) {

            if (input == null) {
                System.out.println("Unable to find credentials.properties");
                System.exit(1);
            }
            properties.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(1);
        }
        return properties;
    }

}
