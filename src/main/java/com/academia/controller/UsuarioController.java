package com.academia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.academia.entity.UsuarioSistema;
import com.academia.service.RolService;
import com.academia.service.UsuarioService;

@Controller
@RequestMapping("/gestionusuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RolService rolService;

    @GetMapping("/lista")
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.listar());
        model.addAttribute("roles", rolService.listar());
        model.addAttribute("usuarioObj", new UsuarioSistema());
        model.addAttribute("vista", "usuarios");
        return "menu/menu";
    }

    @PostMapping("/registrar")
    public String registrar(UsuarioSistema usuarioObj) {
        usuarioService.registrar(usuarioObj);
        return "redirect:/gestionusuario/lista";
    }

    @PostMapping("/actualizar")
    public String actualizar(UsuarioSistema usuarioObj) {
        usuarioService.actualizar(usuarioObj);
        return "redirect:/gestionusuario/lista";
    }

    @GetMapping("/buscar/{id}")
    @ResponseBody
    public UsuarioSistema buscar(@PathVariable int id) {
        return usuarioService.buscarPorId(id);
    }

    @GetMapping("/desactivar/{id}")
    public String desactivar(@PathVariable int id) {
        usuarioService.desactivar(id);
        return "redirect:/gestionusuario/lista";
    }
}
