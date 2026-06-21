package com.academia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academia.entity.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer> {

}
