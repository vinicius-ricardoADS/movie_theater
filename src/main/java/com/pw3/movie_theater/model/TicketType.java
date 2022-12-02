package com.pw3.movie_theater.model;

public enum TicketType {
    HALF ("Half ticket"),
    NORMAL ("Normal ticket");

    private String description;

    TicketType (String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
