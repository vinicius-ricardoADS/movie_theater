package com.pw3.movie_theater.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pw3.movie_theater.dao.GenericDao;
import com.pw3.movie_theater.model.Session;

import java.util.List;

@Service
public class SessionServiceImpl implements GenericService<Session, Long>{

    @Autowired
    private GenericDao<Session, Long> dao;

    @Transactional(readOnly = false)
    @Override
    public void save(Session session) {
        dao.save(session);
    }

    @Transactional(readOnly = false)
    @Override
    public void update(Session session) {
        dao.update(session);  
    }

    @Transactional(readOnly = false)
    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Session> findAll() {
        return dao.findAll();
    }

    @Override
    public Session findById(Long id) {
        return dao.findById(id);
    }
    
}
