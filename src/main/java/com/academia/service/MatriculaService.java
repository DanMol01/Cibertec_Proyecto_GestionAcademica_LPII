package com.academia.service;

import java.util.List;

import com.academia.entity.Matricula;

public interface MatriculaService {

    List<Matricula> listar();

    void registrar(Matricula obj);

    void actualizar(Matricula obj);

    void desactivar(int id);

    Matricula buscarPorId(int id);
}