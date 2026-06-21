package com.academia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academia.entity.Horario;

public interface HorarioRepository extends JpaRepository<Horario, Integer> {

}