package com.academia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.academia.entity.Matricula;
import com.academia.service.CursoHorarioService;
import com.academia.service.EstudianteService;
import com.academia.service.MatriculaService;

@Controller
@RequestMapping("/gestionmatricula")
public class MatriculaController {

    @Autowired
    private MatriculaService matriculaService;

    @Autowired
    private EstudianteService estudianteService;

    @Autowired
    private CursoHorarioService cursoHorarioService;

    @GetMapping("/lista")
    public String listarMatriculas(Model model) {
        model.addAttribute("matriculas", matriculaService.listar());
        model.addAttribute("estudiantes", estudianteService.listar());
        model.addAttribute("cursoHorarios", cursoHorarioService.listar());
        model.addAttribute("matricula", new Matricula());
        model.addAttribute("vista", "matriculas");
        return "menu/menu";
    }

    @PostMapping("/registrar")
    public String registrar(Matricula matricula, RedirectAttributes redirect) {
        matriculaService.registrar(matricula);
        redirect.addFlashAttribute("msg","Matricula registrado correctamente");
        return "redirect:/gestionmatricula/lista";
    }

    @PostMapping("/actualizar")
    public String actualizar(Matricula matricula, RedirectAttributes redirect) {
        matriculaService.actualizar(matricula);
        redirect.addFlashAttribute("msg","Matricula actualizado correctamente");
        return "redirect:/gestionmatricula/lista";
    }

    @GetMapping("/buscar/{id}")
    @ResponseBody
    public Matricula buscar(@PathVariable int id) {
        return matriculaService.buscarPorId(id);
    }

    @GetMapping("/desactivar/{id}")
    public String desactivar(@PathVariable int id, RedirectAttributes redirect) {
        matriculaService.desactivar(id);
        redirect.addFlashAttribute("msg","Matricula desactivado correctamente");
        return "redirect:/gestionmatricula/lista";
    }
}