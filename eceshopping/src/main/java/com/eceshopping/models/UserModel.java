package com.eceshopping.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

/**
 * UserModel class is used to create a user object that will be used to store
 * user information in the database.
 */
@Entity
@Table(name = "Users")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Column(name = "name")
    private String username;

    @NotBlank
    @Column(name = "password")
    private String password;

    @NotBlank
    @Email
    @Column(name = "email", unique = true)
    private String email;

    @NotBlank
    @Column(name = "admin")
    private boolean admin;

    /**
     * Default constructor for the UserModel class. This constructor is used to
     * create a new user object. It instantiates the username, password, email,
     * and admin variables to empty strings and false respectively.
     */
    public UserModel() {
        this.username = "";
        this.password = "";
        this.email = "";
        this.admin = false;
    }

    /**
     * Overloaded constructor for the UserModel class. This constructor is used to
     * create a new user object. It instantiates the username, password, email,
     * and admin variables to the values passed in.
     * 
     * @param username A string containing the username of the user.
     * @param password A string containing the password of the user.
     * @param email    A string containing the email of the user.
     * @param admin    A boolean value indicating whether the user is an admin or
     *                 not.
     */
    public UserModel(String username, String password, String email, boolean admin) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.admin = admin;
    }

    /**
     * Gets the user Id.
     * 
     * @return An integer containing the user Id.
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the user Id.
     * 
     * @param id An integer containing the user Id.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the username of the user.
     * 
     * @return A string containing the username of the user.
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Sets the username of the user.
     * 
     * @param username A string containing the username of the user.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password of the user.
     * 
     * @return A string containing the password of the user.
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Sets the password of the user.
     * 
     * @param password A string containing the password of the user.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the email of the user.
     * 
     * @return A string containing the email of the user.
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Sets the email of the user.
     * 
     * @param email A string containing the email of the user.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets the admin status of the user.
     * 
     * @return A boolean value indicating whether the user is an admin or not.
     */
    public boolean getAdmin() {
        return this.admin;
    }

    /**
     * Sets the admin status of the user.
     * 
     * @param admin A boolean value indicating whether the user is an admin or not.
     */
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    /**
     * Sets the user Id and returns the current UserModel object.
     * 
     * @param id An integer containing the user Id.
     * @return A UserModel object containing the user Id.
     */
    public UserModel id(Integer id) {
        setId(id);
        return this;
    }

    /**
     * Sets the username of the user and returns the current UserModel object.
     * 
     * @param username A string containing the username of the user.
     * @return A UserModel object containing the username of the user.
     */
    public UserModel username(String username) {
        setUsername(username);
        return this;
    }

    /**
     * Sets the password of the user and returns the current UserModel object.
     * 
     * @param password A string containing the password of the user.
     * @return A UserModel object containing the password of the user.
     */
    public UserModel password(String password) {
        setPassword(password);
        return this;
    }

    /**
     * Sets the email of the user and returns the current UserModel object.
     * 
     * @param email A string containing the email of the user.
     * @return A UserModel object containing the email of the user.
     */
    public UserModel email(String email) {
        setEmail(email);
        return this;
    }

    /**
     * Sets the admin status of the user and returns the current UserModel object.
     * 
     * @param admin A boolean value indicating whether the user is an admin or not.
     * @return A UserModel object containing the admin status of the user.
     */
    public UserModel admin(boolean admin) {
        setAdmin(admin);
        return this;
    }

    /**
     * Returns a string representation of the user object.
     * 
     * @return A string containing the user Id, username, password, email, and admin
     *         status.
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
