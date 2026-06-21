package com.academia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academia.entity.CursoHorario;
import com.academia.repository.CursoHorarioRepository;

@Service
public class CursoHorarioServiceImpl implements CursoHorarioService {

    @Autowired
    private CursoHorarioRepository cursoHorarioRepository;

    @Override
    public List<CursoHorario> listar() {
        return cursoHorarioRepository.findAll();
    }

    @Override
    public void registrar(CursoHorario obj) {
        cursoHorarioRepository.save(obj);
    }

    @Override
    public void actualizar(CursoHorario obj) {
        cursoHorarioRepository.save(obj);
    }

    @Override
    public void desactivar(int id) {
        CursoHorario ch = buscarPorId(id);

        if (ch != null) {
            ch.setEstado("Inactivo");
            cursoHorarioRepository.save(ch);
        }
    }

    @Override
    public CursoHorario buscarPorId(int id) {
        return cursoHorarioRepository.findById(id).orElse(null);
    }
}