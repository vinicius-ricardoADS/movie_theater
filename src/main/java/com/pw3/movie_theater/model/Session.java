package com.pw3.movie_theater.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "sessions")
public class Session extends AbstractEntity<Long> {

    @Column (nullable = false)
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate date;

    @Column (nullable = false)
    @DateTimeFormat(iso = ISO.TIME)
    private LocalTime time;

    @ManyToOne
    @JoinColumn(name = "movie_id_fk")
    private Movie movie;

    @Column (name = "numberLivingRoom", nullable = true)
    private Integer livingRoom;

    @OneToMany(mappedBy = "session")
    private List<Ticket> tickets;

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

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

}
