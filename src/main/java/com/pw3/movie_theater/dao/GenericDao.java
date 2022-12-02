package com.pw3.movie_theater.dao;

import java.util.List;

public interface GenericDao<T, K> {

    void save(T type);

    void update(T type);
    
    void delete(K id);

    List<T> findAll();
}
