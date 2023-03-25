package com.eceshopping.configs;

import static org.junit.Assert.assertNotNull;
import org.hibernate.SessionFactory;
import org.junit.Test;

public class HibernateConfigTest {

    @Test
    public void testGetSessionFactory() {
        HibernateConfig hibernateConfig = new HibernateConfig();
        SessionFactory sessionFactory = hibernateConfig.getSessionFactory();
        assertNotNull("sessionFactory should not be null", sessionFactory);
    }

}