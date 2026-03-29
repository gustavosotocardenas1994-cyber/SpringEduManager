package com.panaderia.rodrigo.repository;

import com.panaderia.rodrigo.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

    Optional<Estudiante> findByEmail(String email);

    List<Estudiante> findByNombreContainingIgnoreCase(String nombre);

    boolean existsByEmail(String email);
}