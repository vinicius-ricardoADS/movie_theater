package com.pw3.movie_theater.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pw3.movie_theater.dao.GenericDao;
import com.pw3.movie_theater.model.Client;

@Service
public class ClientServiceImpl implements GenericService<Client, Long>{

    @Autowired
    private GenericDao<Client, Long> dao;

    @Transactional(readOnly = false)
    @Override
    public void save(Client client) {
        dao.save(client);
    }

    @Transactional(readOnly = false)
    @Override
    public void update(Client client) {
        dao.update(client);  
    }

    @Transactional(readOnly = false)
    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Client> findAll() {
        return dao.findAll();
    }

    @Override
    public Client findById(Long id) {
        return dao.findById(id);
    }
    
}
