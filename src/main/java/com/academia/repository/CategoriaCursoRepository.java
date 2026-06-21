package com.academia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academia.entity.CategoriaCurso;

public interface CategoriaCursoRepository extends JpaRepository<CategoriaCurso, Integer> {
}