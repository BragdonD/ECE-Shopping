package com.eceshopping.models;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class UserModelTest {
    @Test
    public void testUserModel() {
        UserModel user = new UserModel("test", "test", "test", true);
        assertEquals("test", user.getUsername());
        assertEquals("test", user.getPassword());
        assertEquals("test", user.getEmail());
        assertEquals(true, user.getAdmin());
    }

    @Test
    public void testUserUpgradeToAdmin() {
        UserModel user = new UserModel("test", "test", "test", false);
        assertEquals(false, user.getAdmin());
        user.setAdmin(true);
        assertEquals(true, user.getAdmin());
    }
}
