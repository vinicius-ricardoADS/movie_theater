package com.pw3.movie_theater.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pw3.movie_theater.model.Client;
import com.pw3.movie_theater.service.GenericService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private GenericService<Client, Long> service;

    @GetMapping("/cadastrar")
    public String cadastrar(Client client, ModelMap model) {
        if (!model.containsKey("cliente"))
            model.addAttribute("cliente", new Client());
        return "/cliente/cadastro";
    }

    @PostMapping("/salvar")
    public String salvar(Client client, RedirectAttributes attr) {
        service.save(client);
        attr.addFlashAttribute("success", "Cliente cadastrado com sucesso!");
        return "redirect:/clientes/cadastrar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {

        model.addAttribute("cliente", service.findById(id));
        return "/cliente/cadastro";
    }

    @PostMapping("/editar")
    public String editar(Client client, RedirectAttributes attr) {
        service.update(client);
        attr.addFlashAttribute("success", "Cliente editado com sucesso!");
        return "redirect:/clientes/listar";
    }

    @GetMapping("/listar")
    public String listar(ModelMap map, HttpSession session) {
        if (session.getAttribute("admin") != null) {
            map.addAttribute("clientes", service.findAll());
            return "/cliente/lista";
        }
        return "/admins/cadastrar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
        service.delete(id);
        attr.addFlashAttribute("success", "Filme excluido com sucesso!");

        return "redirect:/clientes/listar";
    }
}
