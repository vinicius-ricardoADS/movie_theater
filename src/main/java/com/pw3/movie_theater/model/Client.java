package com.pw3.movie_theater.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "clients")
public class Client extends AbstractEntity<Long> {

    @Column (name = "name", nullable = false, length = 60)
    private String name;

    @Column (name = "birthDate", nullable = false)
    private LocalDate birthDate;

    @Column (name = "CPF", nullable = false, unique = true, length = 14)
    private String cpf;

    @Column (name = "phone", nullable = true, length = 12)
    private String phone;

    public int getAge (LocalDate birthDate) {
        return LocalDate.now().getYear() -  birthDate.getYear(); 
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    
    
}
