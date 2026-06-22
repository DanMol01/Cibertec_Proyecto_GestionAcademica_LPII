package com.academia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String registrar(UsuarioSistema usuarioObj, RedirectAttributes redirect) {
        usuarioService.registrar(usuarioObj);
        redirect.addFlashAttribute("msg", "Usuario registrado correctamente");
        return "redirect:/gestionusuario/lista";
    }

    @PostMapping("/actualizar")
    public String actualizar(UsuarioSistema usuarioObj, RedirectAttributes redirect) {
        usuarioService.actualizar(usuarioObj);
        redirect.addFlashAttribute("msg", "Usuario actualizado correctamente");
        return "redirect:/gestionusuario/lista";
    }

    @GetMapping("/desactivar/{id}")
    public String desactivar(@PathVariable int id, RedirectAttributes redirect) {
        usuarioService.desactivar(id);
        redirect.addFlashAttribute("msg", "Usuario desactivado correctamente");
        return "redirect:/gestionusuario/lista";
    }

    @GetMapping("/buscar/{id}")
    @ResponseBody
    public UsuarioSistema buscar(@PathVariable int id) {
        return usuarioService.buscarPorId(id);
    }
}
