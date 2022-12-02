package com.pw3.movie_theater.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee extends AbstractEntity<Long>{

    @Column(name = "name", unique = true, nullable = false)
    private String email;

    @Column(name = "password", nullable = false, columnDefinition= "char(128)")
    private String hashPassword;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }

    
}
