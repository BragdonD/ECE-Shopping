package com.eceshopping;

import com.eceshopping.dto.UserDto;
import com.eceshopping.factories.UserFactory;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class RandomAdminUserGeneratorApp {
    public static void main(String[] args) {
        UserDto randomUser = UserFactory.createRandomUser();
        UserDto user = UserFactory.createAdminUser(randomUser.getUsername(), randomUser.getEmail(),
                randomUser.getPassword());
        System.out.print("User created: ");
        System.out.println(user);
        // Encrypt password
        user.setPassword(BCrypt.withDefaults().hashToString(12, user.getPassword().toCharArray()));
        System.out.println("If you want to insert this user in the database, copy the following query:");
        System.out.print("SQL Query: ");
        System.out.println("INSERT INTO users (name, email, password, admin) VALUES ('" + user.getUsername()
                + "', '" + user.getEmail() + "', '" + user.getPassword() + "', " + user.getAdmin() + ");");
    }
}
