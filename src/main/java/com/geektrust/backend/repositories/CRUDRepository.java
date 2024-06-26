package com.geektrust.backend.repositories;

import java.util.*;


public interface CRUDRepository<T,ID> {
    public T save(T entity);
    public List<T> findAll();
    public Optional<T> findById(ID id);
    boolean existsById(ID id);
    public void delete(T entity);
    public void deleteById(ID id);
    public long count();
}
