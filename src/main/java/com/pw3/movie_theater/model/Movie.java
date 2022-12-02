package com.pw3.movie_theater.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "movies")
public class Movie extends AbstractEntity<Long>{

    @Column (name = "name", nullable = false, length = 100)
    private String name;

    @Column (name = "releaseDate", nullable = false)
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate releaseDate;

    @Column (name = "duration", nullable = true)
    private Integer duration;

    @Column (name = "directorName", nullable = false, length = 60)
    private String director;

    @Column (name = "movieGenre", nullable = false)
    @Enumerated(EnumType.STRING)
    private MovieGenre movieGenre;

    @Column (name = "classification", nullable = true)
    private Integer classification;

    @OneToMany(mappedBy = "movie")
    private List<Session> sessions;

    public boolean hasGenre() {
        if (getMovieGenre() == null)
            return false;
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public MovieGenre getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(MovieGenre movieGenre) {
        this.movieGenre = movieGenre;
    }

    public Integer getClassification() {
        return classification;
    }

    public void setClassification(Integer classification) {
        this.classification = classification;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    
}
