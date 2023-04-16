package com.eceshopping.configs;

import java.util.Properties;
import org.flywaydb.core.Flyway;

/*
 * This class is used to configure the database migration tool Flyway
 */
public class FlywayConfig {
    private static FlywayConfig instance;
    Properties flywayProperties;

    /*
     * This method is used to configure the Flyway tool
     */
    private FlywayConfig() {
        Properties properties = HibernateConfig.getDevelopmentProperties();
        this.flywayProperties = new Properties();
        this.flywayProperties.setProperty("flyway.url", properties.getProperty("hibernate.connection.url"));
        Flyway flyway = Flyway.configure()
                .dataSource(properties.getProperty("hibernate.connection.url"), null, null)
                .load();
        flyway.migrate();
    }

    
    /** 
     * @return FlywayConfig
     */
    /*
     * This method is used to get the instance of the FlywayConfig class
     */
    public static FlywayConfig getInstance() {
        if (instance == null) {
            instance = new FlywayConfig();
        }
        return instance;
    }
}
