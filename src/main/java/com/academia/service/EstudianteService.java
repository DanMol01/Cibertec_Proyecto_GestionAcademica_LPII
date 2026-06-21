package com.academia.service;

import java.util.List;

import com.academia.entity.Estudiante;

public interface EstudianteService {

    List<Estudiante> listar();
    void registrar(Estudiante obj);
    void actualizar(Estudiante obj);
    void desactivar(int id);
    Estudiante buscarPorId(int id);
}