package com.academia.service;

import java.util.List;

import com.academia.entity.Curso;

public interface CursoService {

    List<Curso> listar();

    void registrar(Curso obj);

    void actualizar(Curso obj);

    void desactivar(int id);

    Curso buscarPorId(int id);
}