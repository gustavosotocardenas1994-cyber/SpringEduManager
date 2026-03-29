package com.panaderia.rodrigo.service;

import com.panaderia.rodrigo.model.Estudiante;
import com.panaderia.rodrigo.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    public List<Estudiante> findAll() {
        return estudianteRepository.findAll();
    }

    public Estudiante findById(Long id) {
        return estudianteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado con ID: " + id));
    }

    public Estudiante findByEmail(String email) {
        return estudianteRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado con email: " + email));
    }

    public List<Estudiante> buscarPorNombre(String nombre) {
        return estudianteRepository.findByNombreContainingIgnoreCase(nombre);
    }

    public Estudiante save(Estudiante estudiante) {
        if (estudiante.getId() == null && estudianteRepository.existsByEmail(estudiante.getEmail())) {
            throw new RuntimeException("Ya existe un estudiante con el email: " + estudiante.getEmail());
        }
        return estudianteRepository.save(estudiante);
    }

    public Estudiante update(Long id, Estudiante estudianteActualizado) {
        Estudiante existente = findById(id);
        existente.setNombre(estudianteActualizado.getNombre());
        existente.setEmail(estudianteActualizado.getEmail());
        return estudianteRepository.save(existente);
    }

    public void delete(Long id) {
        Estudiante estudiante = findById(id);
        estudianteRepository.delete(estudiante);
    }

    public long count() {
        return estudianteRepository.count();
    }
}