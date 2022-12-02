package com.pw3.movie_theater.dao;

import org.springframework.stereotype.Repository;

import com.pw3.movie_theater.model.Ticket;

@Repository
public class TicketDaoImpl extends AbstractDao<Ticket, Long> implements GenericDao<Ticket, Long> {
}
