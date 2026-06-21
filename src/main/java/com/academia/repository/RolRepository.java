package com.academia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academia.entity.Rol;

public interface RolRepository extends JpaRepository<Rol, Integer> {
}