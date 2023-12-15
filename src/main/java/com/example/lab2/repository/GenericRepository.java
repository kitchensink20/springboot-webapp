package com.example.lab2.repository;

import java.util.List;

public interface GenericRepository<T> {
    T findById(int id);
    List<T> findAll();
    T create(T newEntity);
    T update(T modifiedEntity);
    void deleteById(int id);
}
