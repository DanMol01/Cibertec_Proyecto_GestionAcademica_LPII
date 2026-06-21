package com.academia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academia.entity.CategoriaCurso;
import com.academia.repository.CategoriaCursoRepository;

@Service
public class CategoriaCursoServiceImpl implements CategoriaCursoService {

    @Autowired
    private CategoriaCursoRepository categoriaCursoRepository;

    @Override
    public List<CategoriaCurso> listar() {
        return categoriaCursoRepository.findAll();
    }
}