package com.eceshopping.configs;

import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.eceshopping.models.ArticleModel;
import com.eceshopping.models.PurchaseModel;
import com.eceshopping.models.PurchasedItemModel;
import com.eceshopping.models.UserModel;

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
        String activeProfile = System.getProperty("app.profiles.active", "prod");
        if (activeProfile.equals("dev")) {
            hibernateProperties = getDevelopmentProperties();
        } else if (activeProfile.equals("test")) {
            hibernateProperties = getTestProperties();
        } else {
            hibernateProperties = getProductionProperties();
        }
        sessionFactory = new Configuration()
                .addProperties(hibernateProperties)
                .addAnnotatedClass(UserModel.class)
                .addAnnotatedClass(ArticleModel.class)
                .addAnnotatedClass(PurchaseModel.class)
                .addAnnotatedClass(PurchasedItemModel.class)
                .buildSessionFactory();
    }

    /**
     * Gets the Hibernate properties for production environment.
     * 
     * @return The Hibernate properties for production environment.
     */
    public static Properties getProductionProperties() {
        Properties properties = new Properties();
        properties.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
        properties.setProperty("hibernate.connection.username", "root");
        properties.setProperty("hibernate.connection.password", "root");
        properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/test");
        properties.setProperty("hibernate.archive.autodetection", "class, hbm");
        properties.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        properties.setProperty("hibernate.hbm2ddl.auto", "validate");
        return properties;
    }

    /**
     * Gets the Hibernate properties for development environment.
     * 
     * @return The Hibernate properties for development environment.
     */
    public static Properties getDevelopmentProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.community.dialect.SQLiteDialect");
        properties.setProperty("hibernate.connection.driver_class", "org.sqlite.JDBC");
        properties.setProperty("hibernate.connection.url", "jdbc:sqlite:src/main/resources/db/test_db.db");
        properties.setProperty("hibernate.archive.autodetection", "class, hbm");
        properties.setProperty("hibernate.hbm2ddl.auto", "validate");
        return properties;
    }

    /**
     * Gets the Hibernate properties for test environment.
     * 
     * @return The Hibernate properties for test environment.
     */
    public static Properties getTestProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.community.dialect.SQLiteDialect");
        properties.setProperty("hibernate.connection.driver_class", "org.sqlite.JDBC");
        properties.setProperty("hibernate.connection.url", "jdbc:sqlite:src/test/resources/db/test_db.db");
        properties.setProperty("hibernate.archive.autodetection", "class, hbm");
        properties.setProperty("hibernate.hbm2ddl.auto", "validate");
        return properties;
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
