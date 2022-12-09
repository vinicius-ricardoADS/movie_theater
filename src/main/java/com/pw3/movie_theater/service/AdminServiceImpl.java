package com.pw3.movie_theater.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pw3.movie_theater.dao.GenericDao;
import com.pw3.movie_theater.model.Admin;

@Service
public class AdminServiceImpl implements GenericService<Admin, Long> {

    @Autowired
    private GenericDao<Admin, Long> dao;

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    public List<Admin> findAll() {
        return dao.findAll();
    }

    @Override
    public Admin findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public void save(Admin type) {
        dao.save(type);
    }

    @Override
    public void update(Admin type) {
        dao.update(type);
    }

}
