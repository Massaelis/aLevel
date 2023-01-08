package com.prodius.repository;

import com.prodius.model.Car;

import java.util.Optional;

public interface Repository<T> {
    void save(final T t);
   // void insert(int index, final T t);
    Optional<Car> getById(final String id);
    T[] getAll();
    void delete(final String id);
}
