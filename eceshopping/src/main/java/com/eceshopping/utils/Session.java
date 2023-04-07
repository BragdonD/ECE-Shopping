package com.eceshopping.utils;

import com.eceshopping.dto.UserDto;

/**
 * Session class is used to store the current user in memory.
 * @implNote This class is a singleton.
 * @implNote This class is not in its final state.
 */
public class Session {
    private UserDto user;
    private static Session instance;

    /**
     * Default constructor for the Session class.
     */
    private Session() {
        this.user = null;
    }

    /**
     * This method is used to get the instance of the Session class.
     * @return
     */
    public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

    /**
     * This method is used to get the current user in the session.
     * @return The current user in the session
     */
    public UserDto getUser() {
        return user;
    }

    /**
     * This method is used to set the current user in the session.
     * @param user The current user in the session
     */
    public void setUser(UserDto user) {
        this.user = user;
    }
    
    /**
     * This method is used to clear the current session for the future user.
     */
    public void clear() {
        this.user = null;
    }

    /**
     * This method is used to set the current user in the session.
     * @param user The current user in the session
     * @return The current session
     */
    public Session user(UserDto user) {
        this.user = user;
        return this;
    }


    @Override
    public String toString() {
        return "{" +
            " user='" + getUser() + "'" +
            "}";
    }

}
