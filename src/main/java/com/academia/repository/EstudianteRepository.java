package com.academia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academia.entity.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {

}
