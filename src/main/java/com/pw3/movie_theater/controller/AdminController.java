package com.pw3.movie_theater.controller;

import java.io.IOException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pw3.movie_theater.controller.utils.StringToHashConverter;
import com.pw3.movie_theater.model.Admin;
import com.pw3.movie_theater.service.AdminService;

@Controller
@RequestMapping("/admins")
public class AdminController {

    @Autowired
    private AdminService service;

    @GetMapping("/cadastrar")
    public String cadastrar(Admin admin, ModelMap model) {
        if (!model.containsKey("admin"))
            model.addAttribute("admin", new Admin());
        return "/admin/cadastro";
    }

    @PostMapping("/salvar")
    public String salvar(Admin admin, RedirectAttributes attr) {
        String senhaHash = StringToHashConverter.stringToHash(admin.getVirtualPassword());
        admin.setVirtualPassword(senhaHash);
        service.save(admin);
        attr.addFlashAttribute("success", "Administrador cadastrado com sucesso!");
        return "redirect:/admins/cadastrar";
    }

    @GetMapping("/preLogin")
    public String preLogin(Admin admin, ModelMap model) {
        if (!model.containsKey("admin"))
            model.addAttribute("admin", new Admin());
        return "/admin/login";
    }
    
    @PostMapping("/login")
    public String login(Admin admin, RedirectAttributes attr, HttpSession session) {

        String senhaHash = StringToHashConverter.stringToHash(admin.getVirtualPassword());
        Admin adminBuscado = service.findByUsernameAndPassword(admin.getUsername(), senhaHash);
        if (adminBuscado != null) {
            session.setAttribute("admin", admin);
            return "redirect:/index";
        } else {
            attr.addFlashAttribute("fail", "Login ou senha incorretos!");
            return "redirect:/admins/preLogin"; 
        }        
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) throws IOException {
        if (session.getAttribute("admin") != null)
            session.removeAttribute("admin");
        return "redirect:/index";
    }

}
