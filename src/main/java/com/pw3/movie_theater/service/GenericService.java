package com.pw3.movie_theater.service;

import java.util.List;

public interface GenericService<T, K> {

    void save(T type);

    void update(T type);
    
    void delete(K id);

    List<T> findAll();

}
