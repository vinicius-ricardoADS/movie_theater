package com.pw3.movie_theater.model;

public enum TicketType {
    NORMAL ("Entrada Inteira"),
    HALF ("Meia Entrada");

    private String description;

    TicketType (String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
