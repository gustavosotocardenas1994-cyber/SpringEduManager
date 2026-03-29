package com.panaderia.rodrigo.service;

import com.panaderia.rodrigo.model.Curso;
import com.panaderia.rodrigo.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    public Curso findById(Long id) {
        return cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado con ID: " + id));
    }

    public List<Curso> buscarPorNombre(String nombre) {
        return cursoRepository.findByNombreContainingIgnoreCase(nombre);
    }

    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Curso update(Long id, Curso cursoActualizado) {
        Curso existente = findById(id);
        existente.setNombre(cursoActualizado.getNombre());
        existente.setDescripcion(cursoActualizado.getDescripcion());
        return cursoRepository.save(existente);
    }

    public void delete(Long id) {
        Curso curso = findById(id);
        cursoRepository.delete(curso);
    }

    public long count() {
        return cursoRepository.count();
    }
}