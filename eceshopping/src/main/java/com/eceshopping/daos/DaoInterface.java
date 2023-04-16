package com.eceshopping.daos;

import java.util.List;

import org.hibernate.HibernateException;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;

/**
 * This interface is used to define the methods of the DAOs
 */
public interface DaoInterface<T, I> {
    public T getById(I id) throws EntityNotFoundException;

    /**
     * This method is used to save an entity to the database.
     * 
     * @param t
     * @return
     * @throws ConstraintViolationException
     */
    public Integer save(T t) throws ConstraintViolationException;

    /**
     * This method is used to update an entity in the database.
     * 
     * @param t
     * @throws ConstraintViolationException
     */

    public void update(T t) throws ConstraintViolationException;

    /**
     * This method is used to delete an entity from the database.
     * 
     * @param t
     * @throws ConstraintViolationException
     */

    public void delete(T t) throws ConstraintViolationException;

    /**
     * This method is used to get all the entities from the database.
     * 
     * @return
     * @throws HibernateException
     */

    public List<T> getAll() throws HibernateException;

    /**
     * This method is used to validate a model. It uses the Validator class to check
     * if the model is valid. If the model is not valid, it throws a
     * ConstraintViolationException.
     * 
     * @param t
     * @throws ConstraintViolationException
     */

    public void validateModel(T t) throws ConstraintViolationException;
}
