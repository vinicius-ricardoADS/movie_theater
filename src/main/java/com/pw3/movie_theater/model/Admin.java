package com.pw3.movie_theater.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "admins")
public class Admin extends AbstractEntity<Long>{

    @Column(name = "username", unique = true, nullable = false, length = 60)
    private String username;

    @Column(name = "password", nullable = false)
    private String virtualPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getVirtualPassword() {
        return virtualPassword;
    }

    public void setVirtualPassword(String virtualPassword) {
        this.virtualPassword = virtualPassword;
    }

    
}
