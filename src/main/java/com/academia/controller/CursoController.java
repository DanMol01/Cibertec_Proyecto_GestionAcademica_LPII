package com.academia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.academia.entity.Curso;
import com.academia.service.CategoriaCursoService;
import com.academia.service.CursoService;

@Controller
@RequestMapping("/gestioncurso")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @Autowired
    private CategoriaCursoService categoriaCursoService;

    @GetMapping("/lista")
    public String listarCursos(Model model) {
        model.addAttribute("cursos", cursoService.listar());
        model.addAttribute("categorias", categoriaCursoService.listar());
        model.addAttribute("curso", new Curso());
        model.addAttribute("vista", "cursos");
        return "menu/menu";
    }

    @PostMapping("/registrar")
    public String registrar(Curso curso) {
        cursoService.registrar(curso);
        return "redirect:/gestioncurso/lista";
    }

    @PostMapping("/actualizar")
    public String actualizar(Curso curso) {
        cursoService.actualizar(curso);
        return "redirect:/gestioncurso/lista";
    }

    @GetMapping("/buscar/{id}")
    @ResponseBody
    public Curso buscar(@PathVariable int id) {
        return cursoService.buscarPorId(id);
    }

    @GetMapping("/desactivar/{id}")
    public String desactivar(@PathVariable int id) {
        cursoService.desactivar(id);
        return "redirect:/gestioncurso/lista";
    }
}