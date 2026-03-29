package com.panaderia.rodrigo.controller;

import com.panaderia.rodrigo.service.CursoService;
import com.panaderia.rodrigo.model.Estudiante;
import com.panaderia.rodrigo.service.EstudianteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @Autowired
    private CursoService cursoService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','EMPLEADO')")
    public String listar(@RequestParam(required = false) String buscar, Model model) {
        if (buscar != null && !buscar.isBlank()) {
            model.addAttribute("estudiantes", estudianteService.buscarPorNombre(buscar));
            model.addAttribute("buscar", buscar);
        } else {
            model.addAttribute("estudiantes", estudianteService.findAll());
        }
        return "estudiantes/lista";
    }

    @GetMapping("/nuevo")
    @PreAuthorize("hasRole('ADMIN')")
    public String formularioNuevo(Model model) {
        model.addAttribute("estudiante", new Estudiante());
        model.addAttribute("titulo", "Nuevo Estudiante");
        return "estudiantes/formulario";
    }

    @PostMapping("/guardar")
    @PreAuthorize("hasRole('ADMIN')")
    public String guardar(@Valid @ModelAttribute Estudiante estudiante,
                          BindingResult result,
                          Model model,
                          RedirectAttributes flash) {

        if (result.hasErrors()) {
            model.addAttribute("titulo", "Nuevo Estudiante");
            return "estudiantes/formulario";
        }

        try {
            estudianteService.save(estudiante);
            flash.addFlashAttribute("mensaje", "Estudiante registrado correctamente ✅");
        } catch (RuntimeException e) {
            flash.addFlashAttribute("error", e.getMessage());
        }

        return "redirect:/estudiantes";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("estudiante", estudianteService.findById(id));
        model.addAttribute("cursos", cursoService.findAll());
        return "estudiantes/formulario";
    }



    @GetMapping("/eliminar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String eliminar(@PathVariable Long id, RedirectAttributes flash) {
        estudianteService.delete(id);
        flash.addFlashAttribute("mensaje", "Estudiante eliminado correctamente 🗑️");
        return "redirect:/estudiantes";
    }
}
