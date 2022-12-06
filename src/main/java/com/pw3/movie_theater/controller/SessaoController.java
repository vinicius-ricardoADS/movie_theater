package com.pw3.movie_theater.controller;

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

import com.pw3.movie_theater.model.Movie;
import com.pw3.movie_theater.model.Session;
import com.pw3.movie_theater.service.GenericService;

@Controller
@RequestMapping("/sessoes")
public class SessaoController {
    
    @Autowired
    private GenericService<Session, Long> sessionService;
    @Autowired
    private GenericService<Movie, Long> movieService;

    @GetMapping("/cadastrar")
    public String cadastrar(Session sessao, ModelMap model) {
        if (!model.containsKey("sessao"))
            model.addAttribute("sessao", new Session());
        return "/sessao/cadastro";
    }

    @PostMapping("/salvar")
    public String salvar (Session sessao, RedirectAttributes attr) {
        sessionService.save(sessao);
        attr.addFlashAttribute("success", "Sessão cadastrada com sucesso!");
        return "redirect:/sessoes/cadastrar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {

        model.addAttribute("sessao", sessionService.findById(id));
        return "/sessao/cadastro";
    }

    @PostMapping("/editar")
    public String editar(Session sessao, RedirectAttributes attr){
        sessionService.update(sessao);
        attr.addFlashAttribute("success", "Sessão editada com sucesso!");
        return "redirect:/sessoes/listar"; 
    }

    @GetMapping("/listar")
    public String listar(ModelMap map){
        map.addAttribute("sessoes",sessionService.findAll());
        return "/sessao/lista"; 
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
        sessionService.delete(id);
        attr.addFlashAttribute("success", "Sessão excluida com sucesso!");
       

        return "redirect:/sessoes/listar";
    }

    @ModelAttribute("filmes")
	public List<Movie> getFilmes() {
		return movieService.findAll();
	}

}
