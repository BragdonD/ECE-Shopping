package com.eceshopping.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

/**
 * UserDto class is used to create a user object that will be used to store user
 * information in the database. This class is used to transfer data between the
 * database and the different application layers.
 */
public class UserDto {
    private Integer id;

    @NotBlank(message = "Username cannot be blank")
    private String username;

    @NotBlank(message = "Password cannot be blank")
    private String password;

    @NotBlank(message = "Email cannot be blank")
    @Email
    private String email;

    private boolean admin;

    /**
     * Default constructor for the UserDto class. This constructor is used to create
     * a new user object. It instantiates the id, username, password, email, and
     * admin variables to -1, empty strings, and false respectively.
     */
    public UserDto() {
        this.id = -1;
        this.username = "";
        this.password = "";
        this.email = "";
        this.admin = false;
    }

    /**
     * Overloaded constructor for the UserDto class. This constructor is used to
     * create a new user object. It instantiates the id, username, password, email,
     * and admin variables to the values passed in as parameters.
     * 
     * @param id       The id of the user
     * @param username The username of the user
     * @param password The password of the user
     * @param email    The email of the user
     * @param admin    The admin status of the user
     */
    public UserDto(Integer id, String username, String password, String email, boolean admin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.admin = admin;
    }

    /**
     * Gets the id of the user.
     * 
     * @return The id of the user
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of the user.
     * 
     * @param id The id of the user
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the username of the user.
     * 
     * @return The username of the user
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Sets the username of the user.
     * 
     * @param username The username of the user
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password of the user.
     * 
     * @return The password of the user
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Sets the password of the user.
     * 
     * @param password The password of the user
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the email of the user.
     * 
     * @return The email of the user
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Sets the email of the user.
     * 
     * @param email The email of the user
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the admin status of the user.
     * 
     * @return The admin status of the user
     */
    public boolean getAdmin() {
        return this.admin;
    }

    /**
     * Sets the admin status of the user.
     * 
     * @param admin The admin status of the user
     */
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    /**
     * Sets the id of the user. This method is used to chain 
     * the id setter method.
     * 
     * @param id The id of the user
     * @return The user object
     */
    public UserDto id(Integer id) {
        setId(id);
        return this;
    }
    
    /**
     * Sets the username of the user. This method is used to chain 
     * the username setter method.
     * 
     * @param username The username of the user
     * @return The user object
     */
    public UserDto username(String username) {
        setUsername(username);
        return this;
    }

    /**
     * Sets the password of the user. This method is used to chain 
     * the password setter method.
     * 
     * @param password The password of the user
     * @return The user object
     */
    public UserDto password(String password) {
        setPassword(password);
        return this;
    }

    /**
     * Sets the email of the user. This method is used to chain 
     * the email setter method.
     * 
     * @param email The email of the user
     * @return The user object
     */
    public UserDto email(String email) {
        setEmail(email);
        return this;
    }

    /**
     * Sets the admin status of the user. This method is used to chain 
     * the admin setter method.
     * 
     * @param admin The admin status of the user
     * @return The user object
     */
    public UserDto admin(boolean admin) {
        setAdmin(admin);
        return this;
    }

    /**
     * Converts the user object to a string. Useful for debugging.
     * 
     * @return The user object as a string
     */
    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", username='" + getUsername() + "'" +
                ", password='" + getPassword() + "'" +
                ", email='" + getEmail() + "'" +
                ", admin='" + getAdmin() + "'" +
                "}";
    }
}
