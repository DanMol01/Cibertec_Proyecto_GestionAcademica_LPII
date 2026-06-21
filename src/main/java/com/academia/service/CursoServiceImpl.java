package com.academia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academia.entity.Curso;
import com.academia.repository.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public List<Curso> listar() {
        return cursoRepository.findAll();
    }

    @Override
    public void registrar(Curso obj) {
        cursoRepository.save(obj);
    }

    @Override
    public void actualizar(Curso obj) {
        cursoRepository.save(obj);
    }

    @Override
    public void desactivar(int id) {
        Curso c = buscarPorId(id);

        if (c != null) {
            c.setEstado("Inactivo");
            cursoRepository.save(c);
        }
    }

    @Override
    public Curso buscarPorId(int id) {
        return cursoRepository.findById(id).orElse(null);
    }
}