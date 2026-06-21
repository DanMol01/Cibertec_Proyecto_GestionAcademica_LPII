package com.academia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academia.entity.TipoDocumento;

public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, Integer> {
}