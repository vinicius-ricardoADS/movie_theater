package com.pw3.movie_theater.dao;

import org.springframework.stereotype.Repository;

import com.pw3.movie_theater.model.Admin;

@Repository
public class AdminDaoImpl extends AbstractDao<Admin, Long> implements AdminDao {

   @Override
   public Admin findByUsernameAndPassword(String username, String password) {
        return createQueryThatReturnsOneResult("select a from Admin a where a.username = ?1 and a.virtualPassword = ?2", username, password);
   }

    
}
