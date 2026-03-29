package com.panaderia.rodrigo.controller;

import com.panaderia.rodrigo.service.CursoService;
import com.panaderia.rodrigo.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private CursoService cursoService;

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("totalCursos", cursoService.count());
        model.addAttribute("totalEstudiantes", estudianteService.count());
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}