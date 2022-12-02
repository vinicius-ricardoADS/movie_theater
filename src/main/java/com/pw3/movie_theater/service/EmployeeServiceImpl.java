package com.pw3.movie_theater.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pw3.movie_theater.dao.GenericDao;
import com.pw3.movie_theater.model.Employee;

@Service
public class EmployeeServiceImpl implements GenericService<Employee, Long>{

    @Autowired
    private GenericDao<Employee, Long> dao;

    @Transactional(readOnly = false)
    @Override
    public void save(Employee employee) {
        dao.save(employee);
    }

    @Transactional(readOnly = false)
    @Override
    public void update(Employee employee) {
        dao.update(employee);  
    }

    @Transactional(readOnly = false)
    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Employee> findAll() {
        return dao.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return dao.findById(id);
    }
    
}
