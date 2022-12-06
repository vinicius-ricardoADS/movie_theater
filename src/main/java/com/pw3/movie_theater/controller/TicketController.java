package com.pw3.movie_theater.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pw3.movie_theater.model.Session;
import com.pw3.movie_theater.model.Ticket;
import com.pw3.movie_theater.service.GenericService;

@Controller
@RequestMapping("/ingressos")
public class TicketController {

    @Autowired
    private GenericService<Ticket, Long> ticketService;
    @Autowired
    private GenericService<Session, Long> sessionService;

    @GetMapping("/comprar/{idSessao}")
    
    public String comprar(@PathVariable("idSessao") Long idSessao, ModelMap model) {
        Ticket ticket = new Ticket();
        Session session = sessionService.findById(idSessao);
        ticket.setSession(session);
        model.addAttribute("ingresso", ticket);

        return "/ingresso/compra";


    }


}
