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
    public void save(T t) throws ConstraintViolationException;
    public void update(T t) throws ConstraintViolationException;
    public void delete(T t) throws ConstraintViolationException;
    public List<T> getAll() throws HibernateException;
    public void validateModel(T t) throws ConstraintViolationException;
}
