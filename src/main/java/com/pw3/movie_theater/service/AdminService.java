package com.pw3.movie_theater.service;

import java.util.List;

import com.pw3.movie_theater.model.Admin;

public interface AdminService {
    
    void save(Admin admin);

    void update(Admin admin);

    void delete(Long id);

    Admin findById(Long id);

    List<Admin> findAll();

    Admin findByUsernameAndPassword(String username, String password);
}
