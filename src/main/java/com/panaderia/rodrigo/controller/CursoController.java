package com.panaderia.rodrigo.controller;

import com.panaderia.rodrigo.model.Curso;
import com.panaderia.rodrigo.service.CursoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public String listar(@RequestParam(required = false) String buscar, Model model) {
        if (buscar != null && !buscar.isBlank()) {
            model.addAttribute("cursos", cursoService.buscarPorNombre(buscar));
            model.addAttribute("buscar", buscar);
        } else {
            model.addAttribute("cursos", cursoService.findAll());
        }
        return "cursos/lista";
    }

    @GetMapping("/nuevo")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public String formularioNuevo(Model model) {
        model.addAttribute("curso", new Curso());
        model.addAttribute("titulo", "Nuevo Curso");
        return "cursos/formulario";
    }

    @PostMapping("/guardar")
    @PreAuthorize("hasRole('ADMIN')")
    public String guardar(@Valid @ModelAttribute Curso curso,
                          BindingResult result,
                          Model model,
                          RedirectAttributes flash) {

        if (result.hasErrors()) {
            model.addAttribute("titulo", curso.getId() == null ? "Nuevo Curso" : "Editar Curso");
            return "cursos/formulario";
        }

        cursoService.save(curso);
        flash.addFlashAttribute("mensaje", "Curso guardado correctamente ✅");
        return "redirect:/cursos";
    }

    @GetMapping("/editar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String formularioEditar(@PathVariable Long id, Model model) {
        model.addAttribute("curso", cursoService.findById(id));
        model.addAttribute("titulo", "Editar Curso");
        return "cursos/formulario";
    }

    @GetMapping("/eliminar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String eliminar(@PathVariable Long id, RedirectAttributes flash) {
        cursoService.delete(id);
        flash.addFlashAttribute("mensaje", "Curso eliminado correctamente 🗑️");
        return "redirect:/cursos";
    }
}