package com.pw3.movie_theater.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pw3.movie_theater.dao.GenericDao;
import com.pw3.movie_theater.model.Ticket;

@Service
public class TicketServiceImpl implements GenericService<Ticket, Long> {

    @Autowired
    private GenericDao<Ticket, Long> dao;

    @Transactional(readOnly = false)
    @Override
    public void save(Ticket ticket) {
        dao.save(ticket);
    }

    @Transactional(readOnly = false)
    @Override
    public void update(Ticket ticket) {
        dao.update(ticket);  
    }

    @Transactional(readOnly = false)
    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Ticket> findAll() {
        return dao.findAll();
    }

    @Override
    public Ticket findById(Long id) {
        return dao.findById(id);
    }
}
