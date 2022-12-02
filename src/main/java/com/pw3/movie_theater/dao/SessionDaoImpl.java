package com.pw3.movie_theater.dao;

import org.springframework.stereotype.Repository;

import com.pw3.movie_theater.model.Session;

@Repository
public class SessionDaoImpl extends AbstractDao<Session, Long> implements GenericDao<Session, Long> {
    
}
