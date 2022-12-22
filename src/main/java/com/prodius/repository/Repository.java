package com.prodius.repository;

public interface Repository<T> {
    void save(final T t);
    void insert(int index, final T t);
    T getById(final String id);
    T[] getAll();
    void delete(final String id);
}
