package com.eceshopping.daos;

import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.SelectionQuery;

import com.eceshopping.configs.HibernateConfig;
import com.eceshopping.models.ArticleModel;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

/**
 * Dao class is used to create a generic Dao object that will be used to perform
 * CRUD operations on the database.
 */
public abstract class Dao<T, I> implements DaoInterface<T, I> {
    private HibernateConfig hibernateConfig;
    private Class<T> entityClass; // Solve the problem of not knowing the type of entity

    /**
     * Constructor for the Dao class. This constructor is used to create a new Dao
     * object.
     * 
     * @param entityClass
     */
    public Dao(Class<T> entityClass) {
        this.hibernateConfig = HibernateConfig.getInstance();
        this.entityClass = entityClass;
    }

    /**
     * This method is used to validate a model. It uses the Validator class to check
     * if the model is valid. If the model is not valid, it throws a
     * ConstraintViolationException.
     * 
     * @throws ConstraintViolationException If the model is not valid.
     */
    @Override
    public void validateModel(T t) throws ConstraintViolationException {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> violations = validator.validate(t);

        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }

    /**
     * This method is used to get an entity by id.
     * 
     * @param id The id of the entity to get.
     * @return An entity object containing the entity information.
     * @throws EntityNotFoundException If the entity does not exist.
     */
    @Override
    public T getById(I id) throws EntityNotFoundException {
        try (Session session = hibernateConfig.getSessionFactory().openSession()) {
            T user = session.get(entityClass, id);
            if (user == null) {
                throw new EntityNotFoundException(
                        this.entityClass.getSimpleName() + " with id " + id + " does not exist.");
            }
            return user;
        }
    }

    /**
     * This method is used to save an entity. You cannot save an entity that is in
     * the database. If you try to save an entity that is in the database, it will
     * throw a HibernateException. So check if the entity is in the database first
     * before saving it.
     * 
     * @param t The entity to save.
     * @throws ConstraintViolationException If the entity is not valid.
     */
    @Override
    public void save(T t) throws ConstraintViolationException {
        validateModel(t);
        try (Session session = hibernateConfig.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(t); // Deprecated but still working so seems fine
            session.getTransaction().commit();
        }
    }

    /**
     * This method is used to update an entity. You need to get the entity first and
     * then update it. You cannot update an entity that is not in the database. If
     * you try to update an entity that is not in the database, it will throw a
     * HibernateException. So check if the entity is in the database first
     * before updating it.
     * 
     * @param t The entity to update.
     * @throws ConstraintViolationException If the entity is not valid.
     */
    @Override
    public void update(T t) throws ConstraintViolationException {
        validateModel(t);
        try (Session session = hibernateConfig.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.merge(t);
            session.getTransaction().commit();
        }
    }

    /**
     * This method is used to delete an entity. You need to get the entity first and
     * then delete it. You cannot delete an entity that is not in the database. If
     * you try to delete an entity that is not in the database, it will throw a
     * HibernateException. So check if the entity is in the database first
     * before deleting it.
     * 
     * @param t The entity to delete.
     * @throws ConstraintViolationException If the entity is not valid.
     */
    @Override
    public void delete(T t) throws ConstraintViolationException {
        validateModel(t);
        try (Session session = hibernateConfig.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.remove(t);
            session.getTransaction().commit();
        }
    }

    /**
     * This method is used to get all the entities.
     * 
     * @return A list of entities.
     * @throws HibernateException If there is an error with Hibernate.
     */
    @Override
    public List<T> getAll() throws HibernateException {
        try (Session session = hibernateConfig.getSessionFactory().openSession()) {
            SelectionQuery<T> query = session.createNamedSelectionQuery(this.entityClass.getSimpleName() + ".findAll",
                    this.entityClass);
            return query.getResultList();
        }
    }

}
