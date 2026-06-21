package com.academia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academia.entity.UsuarioSistema;
import com.academia.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UsuarioSistema validarLogin(String usuario, String clave) {
        return usuarioRepository.findByUsuarioAndClaveAndEstado(usuario, clave, "Activo");
    }

    @Override
    public List<UsuarioSistema> listar() {
        return usuarioRepository.findAll();
    }

    @Override
    public void registrar(UsuarioSistema obj) {
        usuarioRepository.save(obj);
    }

    @Override
    public void actualizar(UsuarioSistema obj) {
        usuarioRepository.save(obj);
    }

    @Override
    public void desactivar(int id) {
        UsuarioSistema u = buscarPorId(id);

        if (u != null) {
            u.setEstado("Inactivo");
            usuarioRepository.save(u);
        }
    }

    @Override
    public UsuarioSistema buscarPorId(int id) {
        return usuarioRepository.findById(id).orElse(null);
    }
}
