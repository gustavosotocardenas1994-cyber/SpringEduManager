package com.panaderia.rodrigo.controller;

import com.panaderia.rodrigo.model.Curso;
import com.panaderia.rodrigo.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoRestController {

    @Autowired
    private CursoService cursoService;

    // 📌 LISTAR TODOS
    @GetMapping
    public List<Curso> listar() {
        return cursoService.findAll();
    }

    // 📌 BUSCAR POR ID
    @GetMapping("/{id}")
    public Curso obtener(@PathVariable Long id) {
        return cursoService.findById(id);
    }

    // 📌 CREAR
    @PostMapping
    public Curso guardar(@RequestBody Curso curso) {
        return cursoService.save(curso);
    }

    // 📌 ACTUALIZAR
    @PutMapping("/{id}")
    public Curso actualizar(@PathVariable Long id, @RequestBody Curso curso) {
        curso.setId(id);
        return cursoService.save(curso);
    }

    // 📌 ELIMINAR
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        cursoService.delete(id);
    }
}