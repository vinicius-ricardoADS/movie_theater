package com.pw3.movie_theater.model;

public enum MovieGenre {
    COMEDY ("Comedy genre"),
    HORROR ("Horror genre"),
    ACTION ("Action genre"),
    THRILLER ("Thriller genre"),
    ADVENTURE ("Adventure genre"),
    DRAMA ("Drama genre"),
    FICTION ("Fiction genre"),
    ROMANCE ("Romance genre");

    private String description;

    MovieGenre (String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
