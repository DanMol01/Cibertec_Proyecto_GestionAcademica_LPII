package com.academia.service;

import java.util.List;

import com.academia.entity.Horario;

public interface HorarioService {

    List<Horario> listar();

    void registrar(Horario obj);

    void actualizar(Horario obj);

    void desactivar(int id);

    Horario buscarPorId(int id);
}