package com.eceshopping.configs;

import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Configuration class for Hibernate ORM framework. This class is a
 * singleton class. It is used to create a SessionFactory object that
 * is used to create a Session object. The Session object is used to
 * perform CRUD operations on the database.
 */
public class HibernateConfig {
    private Properties hibernateProperties;
    private SessionFactory sessionFactory;
    private static HibernateConfig instance;

    /**
     * Default constructor for HibernateConfig class. It creates a
     * SessionFactory object that is used to create a Session object.
     */
    private HibernateConfig() {
        hibernateProperties = new Properties();
        hibernateProperties.setProperty("dialect", "org.hibernate.dialect.PostgresSQL");
        hibernateProperties.setProperty("hibernate.connection.username", "root");
        hibernateProperties.setProperty("hibernate.connection.password", "root");
        hibernateProperties.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        sessionFactory = new Configuration().addProperties(hibernateProperties).buildSessionFactory();
    }

    /**
     * Gets the HibernateConfig instance.
     * 
     * @return Return the HibernateConfig instance.
     */
    public static HibernateConfig getInstance() {
        if (instance == null) {
            instance = new HibernateConfig();
        }
        return instance;
    }

    /**
     * Gets the SessionFactory object.
     * 
     * @return The SessionFactory object.
     */
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}