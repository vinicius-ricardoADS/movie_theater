package com.pw3.movie_theater.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
@Table(name = "sessions")
public class Session extends AbstractEntity<Long> {

    @Column (name = "numberOfSession", nullable = false)
    private Integer number;

    @Column (nullable = false)
    private LocalDate date;

    @Column (nullable = false)
    private LocalTime time;

    @ManyToOne
    @JoinColumn(name = "movie_id_fk")
    private Movie movie;

    @Column (name = "numberLivingRoom", nullable = true)
    private Integer livingRoom;

    @NumberFormat (style = Style.CURRENCY, pattern = "#,##0.00")
    @Column (nullable = false)
    private BigDecimal ticketPrice;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Integer getLivingRoom() {
        return livingRoom;
    }

    public void setLivingRoom(Integer livingRoom) {
        this.livingRoom = livingRoom;
    }

    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(BigDecimal ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    
    
}
