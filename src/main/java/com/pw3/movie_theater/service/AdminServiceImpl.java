package com.pw3.movie_theater.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pw3.movie_theater.dao.AdminDao;
import com.pw3.movie_theater.model.Admin;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminDao dao;

    @Transactional(readOnly = false)
    @Override
    public void save(Admin admin) {
        dao.save(admin);
    }

    @Transactional(readOnly = false)
    @Override
    public void update(Admin admin) {
        dao.update(admin);  
    }

    @Transactional(readOnly = false)
    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Admin> findAll() {
        return dao.findAll();
    }

    @Override
    public Admin findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public Admin findByUsernameAndPassword(String username, String password) {
        return dao.findByUsernameAndPassword(username, password);
    }
    
}
