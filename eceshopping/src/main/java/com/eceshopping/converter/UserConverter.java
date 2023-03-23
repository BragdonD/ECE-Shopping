package com.eceshopping.converter;

import com.eceshopping.dto.UserDto;
import com.eceshopping.models.UserModel;

/**
 * UserConverter class is used to convert between UserDto and UserModel objects.
 */
public class UserConverter {
    /**
     * Converts a UserModel object to a UserDto object. 
     * @param user The UserModel object to be converted
     * @return The converted UserDto object
     */
    public static UserDto convertToDto(UserModel user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setEmail(user.getEmail());
        userDto.setAdmin(user.getAdmin());
        return userDto;
    }

    /**
     * Converts a UserDto object to a UserModel object. 
     * @param userDto The UserDto object to be converted 
     * @return The converted UserModel object
     */
    public static UserModel convertToModel(UserDto userDto) {
        UserModel user = new UserModel();
        user.setId(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setAdmin(userDto.getAdmin());
        return user;
    }
}
