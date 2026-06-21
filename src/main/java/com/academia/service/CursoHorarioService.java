package com.academia.service;

import java.util.List;
import com.academia.entity.CursoHorario;

public interface CursoHorarioService {

    List<CursoHorario> listar();

    void registrar(CursoHorario obj);

    void actualizar(CursoHorario obj);

    void desactivar(int id);

    CursoHorario buscarPorId(int id);
}