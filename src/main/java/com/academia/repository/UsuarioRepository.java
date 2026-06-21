package com.academia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academia.entity.UsuarioSistema;

public interface UsuarioRepository extends JpaRepository<UsuarioSistema, Integer> {

    UsuarioSistema findByUsuarioAndClaveAndEstado(String usuario, String clave, String estado);

}