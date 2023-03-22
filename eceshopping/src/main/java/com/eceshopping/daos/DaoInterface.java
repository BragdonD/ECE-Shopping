package com.eceshopping.daos;

import java.util.List;

public interface DaoInterface<T, I> {
    public T getById(I id) throws RuntimeException;
    public void save(T t) throws RuntimeException;
    public void update(T t) throws RuntimeException;
    public void delete(T t) throws RuntimeException;
    public List<T> getAll() throws RuntimeException;
}
