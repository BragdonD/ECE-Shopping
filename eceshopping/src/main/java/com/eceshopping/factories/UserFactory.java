package com.eceshopping.factories;

import com.eceshopping.dto.UserDto;
import com.github.javafaker.Faker;

/**
 * This class is used to create a user
 */
public class UserFactory {

    private static final Faker faker = new Faker();;

    
    /** 
     * @return UserDto
     */
    public static UserDto createRandomUser() {
        String userName = faker.name().username();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password(8, 16, true, true);

        UserDto newUser = new UserDto()
                .username(userName)
                .email(email)
                .password(password)
                .admin(false);

        return newUser;
    }

    /**
     * This method is used to create a random guest user
     * 
     * @return new user
     */
    public static UserDto createGuestUser(String userName, String email, String password) {
        UserDto newUser = new UserDto()
                .username(userName)
                .email(email)
                .password(password)
                .admin(false);

        return newUser;
    }

    /**
     * This method is used to create a random admin user
     * 
     * @return new user
     */
    public static UserDto createAdminUser(String userName, String email, String password) {
        UserDto newUser = new UserDto()
                .username(userName)
                .email(email)
                .password(password)
                .admin(true);

        return newUser;
    }
}