package com.academia.service;

import java.util.List;

import com.academia.entity.UsuarioSistema;

public interface UsuarioService {

    UsuarioSistema validarLogin(String usuario, String clave);

    List<UsuarioSistema> listar();

    void registrar(UsuarioSistema obj);

    void actualizar(UsuarioSistema obj);

    void desactivar(int id);

    UsuarioSistema buscarPorId(int id);
}
