package com.eceshopping.daos;

import org.hibernate.Session;
import org.hibernate.query.SelectionQuery;

import com.eceshopping.configs.HibernateConfig;
import com.eceshopping.models.UserModel;
import jakarta.persistence.EntityNotFoundException;

/**
 * UserDao class is used to create a user object that will be used to store user
 * information in the database. This class implements the DaoInterface
 * interface. This class contains methods to get a user by id, get a user by
 * email, save a user, update a user, delete a user, and get all users.
 */
public class UserDao extends Dao<UserModel, Integer> {
    private HibernateConfig hibernateConfig;

    /**
     * Default constructor for the UserDao class. It get the instance of the
     * HibernateConfig class.
     */
    public UserDao() {
        super(UserModel.class);
        hibernateConfig = HibernateConfig.getInstance();
    }

    /**
     * This method is used to get a user by email.
     * 
     * @param email The email of the user to get.
     * @return A UserModel object containing the user information.
     * @throws EntityNotFoundException If the user does not exist.
     */
    public UserModel getUserByEmail(String email) throws EntityNotFoundException {
        try (Session session = hibernateConfig.getSessionFactory().openSession()) {
            SelectionQuery<UserModel> query = session.createNamedSelectionQuery("UserModel.findByEmail",
                    UserModel.class);
            query.setParameter("email", email);
            UserModel user = query.getSingleResult();
            if (user == null) {
                throw new EntityNotFoundException("User with email " + email + " does not exist.");
            }
            return user;
        }
    }
}
