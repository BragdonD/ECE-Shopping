package com.eceshopping.configs;

import java.util.Properties;

import org.flywaydb.core.Flyway;

public class FlywayConfig {
    private static FlywayConfig instance;
    Properties flywayProperties;

    private FlywayConfig() {
        Properties properties = HibernateConfig.getDevelopmentProperties();
        this.flywayProperties = new Properties();
        this.flywayProperties.setProperty("flyway.url", properties.getProperty("hibernate.connection.url"));
        Flyway flyway = Flyway.configure()
            .dataSource(properties.getProperty("hibernate.connection.url"), null, null)
            .load();
        flyway.migrate();
    }

    public static FlywayConfig getInstance() {
        if (instance == null) {
            instance = new FlywayConfig();
        }
        return instance;
    }
}
