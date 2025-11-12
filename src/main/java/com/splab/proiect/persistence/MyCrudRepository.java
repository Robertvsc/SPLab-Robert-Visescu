package com.splab.proiect.persistence;

import java.util.List;
import java.util.Optional;

// Task 9: Interfața noastră de abstractizare
public interface MyCrudRepository<T, ID> {
    List<T> findAll();
    Optional<T> findById(ID id);
    T save(T entity);
    void deleteById(ID id);
    boolean existsById(ID id);
}