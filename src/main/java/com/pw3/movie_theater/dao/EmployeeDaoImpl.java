package com.pw3.movie_theater.dao;

import org.springframework.stereotype.Repository;

import com.pw3.movie_theater.model.Employee;

@Repository
public class EmployeeDaoImpl extends AbstractDao<Employee, Long> implements GenericDao<Employee, Long> {
}
