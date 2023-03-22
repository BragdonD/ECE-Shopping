package com.eceshopping.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RouterTest {

    private Router router;

    @Before
    public void setUp() throws Exception {
        router = Router.getInstance();
    }

    @After
    public void tearDown() throws Exception {
        router = null;
    }

    @Test
    public void testGetInstance() {
        assertNotNull("Router instance should not be null", router);
        assertEquals("Router instance should be a singleton", router, Router.getInstance());
    }
}