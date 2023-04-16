package com.eceshopping.services;

import java.util.ArrayList;
import java.util.List;

import com.eceshopping.converter.UserConverter;
import com.eceshopping.daos.UserDao;
import com.eceshopping.dto.UserDto;
import com.eceshopping.models.UserModel;
import com.eceshopping.utils.PasswordValidator;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import javafx.concurrent.Task;

/**
 * UserService class is used to handle business logic for the UserDto and
 * UserModel objects. It is used to encrypt passwords, check passwords, get
 * users by email, save users, update emails, and update passwords.
 */
public class UserService {
    private UserDao userDao;

    /**
     * Default constructor for the UserService class.
     */
    public UserService() {
        this.userDao = new UserDao();
    }

    /**
     * This method is used to encrypt a password using the BCrypt library.
     * 
     * @param password The password to be encrypted
     * @return The encrypted password
     */
    public String encryptPassword(String password) {
        return BCrypt.withDefaults().hashToString(12, password.toCharArray());
    }

    /**
     * This method is used to verify a password using the BCrypt library.
     * 
     * @param password The password to be verified
     * @param hash     The encrypted password
     * @return True if the password is correct, false otherwise
     */
    public boolean verifyPassword(String password, String hash) {
        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), hash);
        return result.verified;
    }

    /**
     * This method is used to get a user by email. It returns a Task object that can
     * be used to get the user asynchronously.
     * 
     * @param email The email of the user
     * @return A Task object that can be used to get the user asynchronously
     */
    public Task<UserDto> getUserByEmailAsync(String email) {
        Task<UserDto> task = new Task<UserDto>() {
            @Override
            protected UserDto call() throws Exception {
                return UserConverter.convertToDto(userDao.getUserByEmail(email));
            }
        };
        return task;
    }

    /**
     * This method is used to get a user by email. It returns the user
     * synchronously.
     * 
     * @param email The email of the user
     * @return The user
     * @throws EntityNotFoundException If the user does not exist
     */
    public UserDto getUserByEmailSync(String email) throws EntityNotFoundException {
        return UserConverter.convertToDto(userDao.getUserByEmail(email));
    }

    /**
     * This method is used to save a user asynchronously to the database.
     * 
     * @param userDto The user to be saved.
     * @throws IllegalArgumentException If the password is not valid or the email is
     *                                  already in use.
     */
    public Task<UserDto> saveUserAsync(UserDto userDto) throws EntityExistsException {
        if (!PasswordValidator.validate(userDto.getPassword())) {
            throw new IllegalArgumentException("Password is not valid.");
        }

        boolean emailExists = true;

        try {
            this.userDao.getUserByEmail(userDto.getEmail());
        } catch (EntityNotFoundException e) {
            emailExists = false;
        }

        if (emailExists) {
            throw new EntityExistsException("Email is already in use.");
        }

        String hashPassword = encryptPassword(userDto.getPassword());
        userDto.setPassword(hashPassword);

        Task<UserDto> task = new Task<UserDto>() {
            @Override
            protected UserDto call() throws Exception {
                UserModel user = UserConverter.convertToModel(userDto);
                userDao.save(user);
                return UserConverter.convertToDto(user);
            }
        };
        return task;
    }

    /**
     * This method is used to update a user's email. It checks if the new email is
     * already in use and if the user exists. If the user does not exist, an
     * EntityNotFoundException is thrown. If the email is already in use, an
     * EntityExistsException is thrown. If the user exists and the email is not in
     * use, the user's email is updated.
     * 
     * @param newEmail The new email
     * @param id       The id of the user
     * @throws EntityExistsException   If the email is already in use
     * @throws EntityNotFoundException If the user does not exist
     */
    public void updateEmail(String newEmail, int id) throws EntityExistsException, EntityNotFoundException {
        if (this.userDao.getUserByEmail(newEmail) != null) {
            throw new EntityExistsException("Email is already in use.");
        }
        if (this.userDao.getById(id) == null) {
            throw new EntityNotFoundException("User does not exist.");
        }
        UserModel user = this.userDao.getById(id);
        user.setEmail(newEmail);
        this.userDao.update(user);
    }

    /**
     * This method is used to update a user's password. It checks if the new
     * password is valid and if the user exists. If the user does not exist, an
     * EntityNotFoundException is thrown. If the password is not valid, an
     * IllegalArgumentException is thrown. If the user exists and the password is
     * valid, the user's password is updated.
     * 
     * @param newPassword     The new password
     * @param currentPassword The current password
     * @param id              The id of the user
     * @throws EntityNotFoundException  If the user does not exist
     * @throws IllegalArgumentException If the password is not valid
     */
    public void updatePassword(String newPassword, String currentPassword, int id)
            throws EntityNotFoundException, IllegalArgumentException {
        if (this.userDao.getById(id) == null) {
            throw new EntityNotFoundException("User does not exist.");
        }
        if (!PasswordValidator.validate(newPassword)) {
            throw new IllegalArgumentException("Password is not valid.");
        }

        UserModel user = this.userDao.getById(id);
        if (!this.verifyPassword(currentPassword, user.getPassword())) {
            throw new IllegalArgumentException("Password is not valid.");
        }

        newPassword = encryptPassword(newPassword);
        user.setPassword(newPassword);
        this.userDao.update(user);
    }

    /**
     * This method is used to update a user's role. It checks if the user exists. If
     * the user does not exist, an EntityNotFoundException is thrown. If the user
     * exists, the user's role is updated.
     * 
     * @param admin The new role
     * @param id    The id of the user
     * @throws EntityNotFoundException If the user does not exist
     */
    public void updateRole(boolean admin, int id) throws EntityNotFoundException {
        if (this.userDao.getById(id) == null) {
            throw new EntityNotFoundException("User does not exist.");
        }
        UserModel user = this.userDao.getById(id);
        user.setAdmin(admin);
        this.userDao.update(user);
    }

    /**
     * This method is used to delete a user. It checks if the user exists. If the
     * user does not exist, an EntityNotFoundException is thrown. If the user
     * exists,
     * the user is deleted.
     * 
     * @param id The id of the user
     * @throws EntityNotFoundException If the user does not exist
     */
    public void delete(int id) throws EntityNotFoundException {
        if (this.userDao.getById(id) == null) {
            throw new EntityNotFoundException("User does not exist.");
        }
        UserModel user = this.userDao.getById(id);
        this.userDao.delete(user);
    }

    public Task<List<UserDto>> getAllUser() {
        Task<List<UserDto>> task = new Task<List<UserDto>>() {
            @Override
            protected List<UserDto> call() throws Exception {
                List<UserModel> users = userDao.getAll();
                List<UserDto> userDtos = new ArrayList<>();
                for (UserModel user : users) {
                    userDtos.add(UserConverter.convertToDto(user));
                }
                return userDtos;
            }
        };
        return task;
    }
}
