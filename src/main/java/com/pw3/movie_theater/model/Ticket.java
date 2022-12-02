package com.pw3.movie_theater.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tickets")
public class Ticket extends AbstractEntity<Long>{

    @Column(name = "value", precision = 8, scale = 2, nullable = false)
    private Double value;

    @ManyToOne
    @JoinColumn(name = "client_id_fk", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "session_id_fk", nullable = false)
    private Session session;

    @Column(name = "purchaseDate", nullable = false)
    private LocalDate purchaseDate;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private TicketType ticketType;

    public Double checkAmountPaid() {
        return quantity * value;
    }

    public Double getValue() {
        return value;
    }


    public void setValue(Double value) {
        this.value = value;
    }


    public Client getClient() {
        return client;
    }


    public void setClient(Client client) {
        this.client = client;
    }


    public Session getSession() {
        return session;
    }


    public void setSession(Session session) {
        this.session = session;
    }


    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }


    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }


    public Integer getQuantity() {
        return quantity;
    }


    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


    public TicketType getTicketType() {
        return ticketType;
    }


    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    
    
    

    
}
