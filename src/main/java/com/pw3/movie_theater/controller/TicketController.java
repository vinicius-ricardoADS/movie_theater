package com.pw3.movie_theater.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pw3.movie_theater.model.Client;
import com.pw3.movie_theater.model.Session;
import com.pw3.movie_theater.model.Ticket;
import com.pw3.movie_theater.model.TicketType;
import com.pw3.movie_theater.service.GenericService;

@Controller
@RequestMapping("/ingressos")
public class TicketController {

    @Autowired
    private GenericService<Ticket, Long> ticketService;
    @Autowired
    private GenericService<Session, Long> sessionService;
    @Autowired
    private GenericService<Client, Long> clientService;

    @GetMapping("/comprar/{idSessao}")
    public String preCompra(@PathVariable("idSessao") Long idSessao, ModelMap model, RedirectAttributes attr) {
        if (clientService.findAll().isEmpty()) {
            attr.addFlashAttribute("fail", "Não é possível realizar a compra de um ingresso, pois não há clientes cadastrados.");
            return "redirect:/sessoes/listar";
        }
        Ticket ticket = new Ticket();
        Session session = sessionService.findById(idSessao);
        ticket.setPurchaseDate(LocalDate.now());
        ticket.setValue(20.00);
        ticket.setSession(session);
        model.addAttribute("ingresso", ticket);

        return "/ingresso/compra";
    }

    @PostMapping("/salvar")
    public String salvar (Ticket ingresso, RedirectAttributes attr) {
        System.out.println(ingresso.getPurchaseDate());
        ticketService.save(ingresso);
        attr.addFlashAttribute("success", "Ingresso comprado com sucesso!");
        return "redirect:/ingressos/listar";
    }

    @GetMapping("/listar")
    public String listar(ModelMap map){
        map.addAttribute("ingressos", ticketService.findAll());
        return "/ingresso/lista"; 
    }

    @GetMapping("/cancelar/{id}")
    public String cancelar(@PathVariable("id") Long id, RedirectAttributes attr){
        if (ticketService.findById(id).isValid()) {
            ticketService.delete(id);
            attr.addFlashAttribute("success", "Compra cancelada com sucesso!");
        }
        return "redirect:/ingressos/listar";
    }

    @ModelAttribute("clientes")
	public List<Client> getClientes() {
		return clientService.findAll();
	}

    @ModelAttribute("tiposIngresso")
	public TicketType[] getTypes() {
		return TicketType.values();
	}


}
