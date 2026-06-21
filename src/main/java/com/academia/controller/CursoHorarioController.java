package com.academia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.academia.entity.CursoHorario;
import com.academia.service.CursoHorarioService;
import com.academia.service.CursoService;
import com.academia.service.HorarioService;

@Controller
@RequestMapping("/gestioncursohorario")
public class CursoHorarioController {

    @Autowired
    private CursoHorarioService cursoHorarioService;

    @Autowired
    private CursoService cursoService;

    @Autowired
    private HorarioService horarioService;

    @GetMapping("/lista")
    public String listarCursoHorarios(Model model) {
        model.addAttribute("cursoHorarios", cursoHorarioService.listar());
        model.addAttribute("cursos", cursoService.listar());
        model.addAttribute("horarios", horarioService.listar());
        model.addAttribute("cursoHorario", new CursoHorario());
        model.addAttribute("vista", "cursoHorarios");
        return "menu/menu";
    }

    @PostMapping("/registrar")
    public String registrar(CursoHorario cursoHorario) {
        cursoHorarioService.registrar(cursoHorario);
        return "redirect:/gestioncursohorario/lista";
    }

    @PostMapping("/actualizar")
    public String actualizar(CursoHorario cursoHorario) {
        cursoHorarioService.actualizar(cursoHorario);
        return "redirect:/gestioncursohorario/lista";
    }

    @GetMapping("/buscar/{id}")
    @ResponseBody
    public CursoHorario buscar(@PathVariable int id) {
        return cursoHorarioService.buscarPorId(id);
    }

    @GetMapping("/desactivar/{id}")
    public String desactivar(@PathVariable int id) {
        cursoHorarioService.desactivar(id);
        return "redirect:/gestioncursohorario/lista";
    }
}