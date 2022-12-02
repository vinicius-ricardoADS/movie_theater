package com.pw3.movie_theater.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pw3.movie_theater.model.Movie;
import com.pw3.movie_theater.service.GenericService;

@Controller
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private GenericService<Movie, Long> service;

    @GetMapping("/cadastrar")
    public String cadastrar(Movie filme, ModelMap model) {
        if (!model.containsKey("filme"))
            model.addAttribute("filme", new Movie());
        return "/filme/cadastro";
    }

    @PostMapping("/salvar")
    public String salvar (Movie filme, RedirectAttributes attr) {
        service.save(filme);
        attr.addFlashAttribute("success", "Filme cadastrado com sucesso!");
        return "redirect:/filmes/cadastrar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {

        model.addAttribute("filme", service.findById(id));
        return "/filme/cadastro";
    }

    @PostMapping("/editar")
    public String editar(Movie filme, RedirectAttributes attr){
        service.update(filme);
        attr.addFlashAttribute("success", "Filme editado com sucesso!");
        return "redirect:/filmes/listar"; 
    }

    @GetMapping("/listar")
    public String listar(ModelMap map){
        map.addAttribute("filmes",service.findAll());
        return "/filme/lista"; 
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
        if (service.findById(id).getSessions().size() == 0) {
            service.delete(id);
            attr.addFlashAttribute("success", "Filme excluido com sucesso!");
        } else {
           attr.addFlashAttribute("fail","Filme não removido. Possui sessão(s) vinculada(s).");
        }

        return "redirect:/filmes/listar";
    }
    
}
