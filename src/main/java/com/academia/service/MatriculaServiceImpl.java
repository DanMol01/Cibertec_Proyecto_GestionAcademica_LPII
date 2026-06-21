package com.academia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academia.entity.CursoHorario;
import com.academia.entity.Matricula;
import com.academia.repository.CursoHorarioRepository;
import com.academia.repository.MatriculaRepository;

@Service
public class MatriculaServiceImpl implements MatriculaService {

    @Autowired
    private MatriculaRepository repoMatricula;
    
    @Autowired
    private CursoHorarioRepository cursoHorarioRepository;

    @Override
    public List<Matricula> listar() {
        return repoMatricula.findAll();
    }

    @Override
    public void registrar(Matricula obj) {

        CursoHorario ch = cursoHorarioRepository
                .findById(obj.getCursoHorario().getIdCursoHorario())
                .orElse(null);

        if (ch != null && ch.getVacantes() > 0) {
            ch.setVacantes(ch.getVacantes() - 1);
            cursoHorarioRepository.save(ch);

            repoMatricula.save(obj);
        }
    }

    @Override
    public void actualizar(Matricula obj) {
    	repoMatricula.save(obj);
    }

    @Override
    public void desactivar(int id) {
        Matricula m = buscarPorId(id);

        if (m != null) {
            m.setEstado("Anulada");
            repoMatricula.save(m);
        }
    }

    @Override
    public Matricula buscarPorId(int id) {
        return repoMatricula.findById(id).orElse(null);
    }
}