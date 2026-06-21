package com.academia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academia.entity.Horario;
import com.academia.repository.HorarioRepository;

@Service
public class HorarioServiceImpl implements HorarioService {

    @Autowired
    private HorarioRepository horarioRepository;

    @Override
    public List<Horario> listar() {
        return horarioRepository.findAll();
    }

    @Override
    public void registrar(Horario obj) {
        horarioRepository.save(obj);
    }

    @Override
    public void actualizar(Horario obj) {
        horarioRepository.save(obj);
    }

    @Override
    public void desactivar(int id) {
        Horario h = buscarPorId(id);

        if (h != null) {
            h.setEstado("Inactivo");
            horarioRepository.save(h);
        }
    }

    @Override
    public Horario buscarPorId(int id) {
        return horarioRepository.findById(id).orElse(null);
    }
}