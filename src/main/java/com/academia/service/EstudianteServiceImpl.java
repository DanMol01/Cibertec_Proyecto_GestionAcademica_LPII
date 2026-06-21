package com.academia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academia.entity.Estudiante;
import com.academia.repository.EstudianteRepository;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Override
    public List<Estudiante> listar() {
        return estudianteRepository.findAll();
    }

    @Override
    public void registrar(Estudiante obj) {
        estudianteRepository.save(obj);
    }

    @Override
    public void actualizar(Estudiante obj) {
        estudianteRepository.save(obj);
    }

    @Override
    public void desactivar(int id) {
        Estudiante e = buscarPorId(id);

        if (e != null) {
            e.setEstado("Inactivo");
            estudianteRepository.save(e);
        }
    }

    @Override
    public Estudiante buscarPorId(int id) {
        return estudianteRepository.findById(id).orElse(null);
    }
}
