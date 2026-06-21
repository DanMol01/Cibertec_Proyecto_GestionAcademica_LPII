package com.academia.service;

import java.util.List;

import com.academia.entity.CursoHorario;

public interface CursoHorarioService {

    List<CursoHorario> listar();

    CursoHorario buscarPorId(int id);

}