package com.eceshopping.factories;

import com.eceshopping.dto.UserDto;
import com.github.javafaker.Faker;

public class UserFactory {

    private static final Faker faker = new Faker();;

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

    public static UserDto createGuestUser(String userName, String email, String password) {
        UserDto newUser = new UserDto()
            .username(userName)
            .email(email)
            .password(password)
            .admin(false);

        return newUser;
    }

    public static UserDto createAdminUser(String userName, String email, String password) {
        UserDto newUser = new UserDto()
            .username(userName)
            .email(email)
            .password(password)
            .admin(true);

        return newUser;
    }
}