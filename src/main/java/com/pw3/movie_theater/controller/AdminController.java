package com.pw3.movie_theater.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pw3.movie_theater.model.Admin;
import com.pw3.movie_theater.service.GenericService;

@Controller
@RequestMapping("/admins")
public class AdminController {

    @Autowired
    private GenericService<Admin, Long> service;

    @GetMapping("/cadastrar")
    public String cadastrar(Admin admin, ModelMap model) {
        if (!model.containsKey("admin"))
            model.addAttribute("admin", new Admin());
        return "/admin/cadastro";
    }

    @PostMapping("/salvar")
    public String salvar(Admin admin, RedirectAttributes attr, HttpSession session) {
        service.save(admin);
        attr.addFlashAttribute("success", "Admin entrou!");
        session.setAttribute("admin", admin);
        return "redirect:/clientes/listar";
    }
}
