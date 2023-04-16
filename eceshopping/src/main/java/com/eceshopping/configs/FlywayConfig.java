package com.eceshopping.configs;

import java.util.Properties;
import org.flywaydb.core.Flyway;

/**
 * This class is used to configure the database migration tool Flyway
 */
public class FlywayConfig {
    private static FlywayConfig instance;
    Properties flywayProperties;

    /**
     * This method is used to configure the Flyway tool
     */
    private FlywayConfig() {
        String activeProfile = System.getProperty("app.profiles.active", "prod");
        Properties properties;
        if (activeProfile.equals("dev")) {
            properties = HibernateConfig.getDevelopmentProperties();
        } else if (activeProfile.equals("test")) {
            properties = HibernateConfig.getTestProperties();
        } else {
            properties = HibernateConfig.getProductionProperties();
        }

        this.flywayProperties = new Properties();
        this.flywayProperties.setProperty("flyway.url", properties.getProperty("hibernate.connection.url"));
        Flyway flyway = Flyway.configure()
                .dataSource(properties.getProperty("hibernate.connection.url"), "root", "root")
                .load();
        flyway.migrate();
    }

    /**
     * This method is used to get the instance of the FlywayConfig class
     * 
     * @return FlywayConfig instance
     */
    public static FlywayConfig getInstance() {
        if (instance == null) {
            instance = new FlywayConfig();
        }
        return instance;
    }
}
