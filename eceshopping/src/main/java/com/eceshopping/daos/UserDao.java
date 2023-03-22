package com.eceshopping.daos;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.query.SelectionQuery;

import com.eceshopping.configs.HibernateConfig;
import com.eceshopping.models.UserModel;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

/**
 * UserDao class is used to create a user object that will be used to store user
 * information in the database. This class implements the DaoInterface
 * interface. This class contains methods to get a user by id, get a user by
 * email, save a user, update a user, delete a user, and get all users.
 */
public class UserDao implements DaoInterface<UserModel, Integer> {
    private HibernateConfig hibernateConfig;

    /**
     * Default constructor for the UserDao class. It get the instance of the
     * HibernateConfig class.
     */
    public UserDao() {
        hibernateConfig = HibernateConfig.getInstance();
    }

    /**
     * This method is used to get a user by id.
     * 
     * @param id The id of the user to get.
     * @return A UserModel object containing the user information.
     * @throws RuntimeException If the user does not exist.
     */
    @Override
    public UserModel getById(Integer id) throws RuntimeException {
        try (Session session = hibernateConfig.getSessionFactory().openSession()) {
            UserModel user = session.get(UserModel.class, id);
            if (user == null) {
                throw new RuntimeException("User with id " + id + " does not exist.");
            }
            return user;
        }
    }

    /**
     * This method is used to get a user by email.
     * 
     * @param email The email of the user to get.
     * @return A UserModel object containing the user information.
     * @throws RuntimeException If the user does not exist.
     */
    public UserModel getUserByEmail(String email) throws RuntimeException {
        try (Session session = hibernateConfig.getSessionFactory().openSession()) {
            SelectionQuery<UserModel> query = session.createSelectionQuery("FROM UserModel WHERE email = :email",
                    UserModel.class);
            query.setParameter("email", email);
            UserModel user = query.getSingleResult();
            if (user == null) {
                throw new RuntimeException("User with email " + email + " does not exist.");
            }
            return user;
        }
    }

    /**
     * This method is used to save a user. It validates the user object and then
     * saves it.
     * 
     * @param user A UserModel object containing the user information.
     */
    @Override
    public void save(UserModel user) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<UserModel>> violations = validator.validate(user);

        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }

        try (Session session = hibernateConfig.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.persist(user);
            session.getTransaction().commit();
        }
    }

    /**
     * This method is used to update a user. It validates the user object and then
     * updates it.
     * 
     * @param user A UserModel object containing the user information.
     */
    @Override
    public void update(UserModel user) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<UserModel>> violations = validator.validate(user);

        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }

        try (Session session = hibernateConfig.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.merge(user);
            session.getTransaction().commit();
        }
    }

    /**
     * This method is used to delete a user. It deletes the user from the database.
     * 
     * @param user A UserModel object containing the user information.
     */
    @Override
    public void delete(UserModel user) {
        try (Session session = hibernateConfig.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.remove(user);
            session.getTransaction().commit();
        }
    }

    /**
     * This method is used to get all users.
     * 
     * @return A List of UserModel objects containing the user information.
     */
    @Override
    public List<UserModel> getAll() {
        try (Session session = hibernateConfig.getSessionFactory().openSession()) {
            SelectionQuery<UserModel> query = session.createSelectionQuery("FROM UserModel", UserModel.class);
            return query.getResultList();
        }
    }
}
