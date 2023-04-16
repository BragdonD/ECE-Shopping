package com.eceshopping;

import java.util.Scanner;

import com.eceshopping.dto.UserDto;
import com.eceshopping.factories.UserFactory;

import at.favre.lib.crypto.bcrypt.BCrypt;

/**
 * A class used to generate an admin user and get the SQL query to insert it in
 * the database
 */
public class AdminUserGeneratorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the admin user generator!");
        System.out.println("This program will generate an admin user and print the SQL query to insert it in the database.");
        System.out.print("Name of the admin user: ");
        String username = scanner.nextLine();
        System.out.print("Email of the admin user: ");
        String email = scanner.nextLine();
        System.out.print("Password of the admin user: ");
        String password = scanner.nextLine();
        scanner.close();
        
        UserDto user = UserFactory.createAdminUser(username, email, password);
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
