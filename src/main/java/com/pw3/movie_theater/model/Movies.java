package com.pw3.movie_theater.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class Movies extends AbstractEntity<Long>{

    @Column (name = "name", nullable = false, length = 100)
    private String name;

    @Column (nullable = false)
    private LocalDate releaseDate;

    @Column (nullable = false)
    private Integer duration;

    @Column (name = "directorName", nullable = true, length = 60)
    private String director;

    @Column (name = "genreMovie", nullable = false)
    @Enumerated(EnumType.STRING)
    private MovieGenre movieGenres;

    @Column (nullable = true)
    private Integer classification;

    public Movies(String name, LocalDate releaseDate, Integer duration, String director, MovieGenre movieGenres,
            Integer classification) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.director = director;
        this.movieGenres = movieGenres;
        this.classification = classification;
    }

    public boolean hasGenre() {
        if (getMovieGenres() == null)
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

    public MovieGenre getMovieGenres() {
        return movieGenres;
    }

    public void setMovieGenres(MovieGenre movieGenres) {
        this.movieGenres = movieGenres;
    }

    public Integer getClassification() {
        return classification;
    }

    public void setClassification(Integer classification) {
        this.classification = classification;
    }

    
}
