package com.pw3.movie_theater.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table (name = "clients")
public class Client extends AbstractEntity<Long> {

    @Column (name = "name", nullable = false, length = 60)
    private String name;

    @Column (name = "birthDate", nullable = false)
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate birthDate;

    @Column (name = "CPF", nullable = false, unique = true, length = 14)
    private String cpf;

    @Column (name = "phone", nullable = true, length = 12)
    private String phone;

    @OneToMany(mappedBy = "client")
    private List<Ticket> tickets;

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

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    
    
}
