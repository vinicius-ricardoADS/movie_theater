package com.pw3.movie_theater.dao;

import org.springframework.stereotype.Repository;

import com.pw3.movie_theater.model.Movie;

@Repository
public class MovieDaoImpl extends AbstractDao<Movie, Long> implements GenericDao<Movie, Long>{
}
