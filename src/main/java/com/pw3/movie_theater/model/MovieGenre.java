package com.pw3.movie_theater.model;

public enum MovieGenre {
    COMEDY ("Comédia"),
    HORROR ("Terror"),
    ACTION ("Ação"),
    THRILLER ("Thriller"),
    ADVENTURE ("Aventura"),
    DRAMA ("Drama"),
    FICTION ("Ficção"),
    ROMANCE ("Romance");

    private String description;

    MovieGenre (String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
