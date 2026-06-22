package com.academia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.academia.entity.Estudiante;
import com.academia.service.EstudianteService;
import com.academia.service.TipoDocumentoService;

@Controller
@RequestMapping("/gestionestudiante")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @Autowired
    private TipoDocumentoService tipoDocumentoService;

    @GetMapping("/lista")
    public String listarEstudiantes(Model model) {
        model.addAttribute("estudiantes", estudianteService.listar());
        model.addAttribute("tiposDocumento", tipoDocumentoService.listar());
        model.addAttribute("estudiante", new Estudiante());
        model.addAttribute("vista", "estudiantes");
        return "menu/menu";
    }

    @PostMapping("/registrar")
    public String registrar(Estudiante estudiante,RedirectAttributes redirect) {

        estudianteService.registrar(estudiante);
        redirect.addFlashAttribute("msg", "Estudiante registrado correctamente");
        return "redirect:/gestionestudiante/lista";
    }

    @PostMapping("/actualizar")
    public String actualizar( Estudiante estudiante,
                             RedirectAttributes redirect) {

        estudianteService.actualizar(estudiante);
        redirect.addFlashAttribute("msg", "Estudiante actualizado correctamente");
        return "redirect:/gestionestudiante/lista";
    }

    @GetMapping("/buscar/{id}")
    @ResponseBody
    public Estudiante buscar(@PathVariable int id) {
        return estudianteService.buscarPorId(id);
    }

    @GetMapping("/desactivar/{id}")
    public String desactivar(@PathVariable int id,
                             RedirectAttributes redirect) {

        estudianteService.desactivar(id);
        redirect.addFlashAttribute("msg", "Estudiante desactivado correctamente");
        return "redirect:/gestionestudiante/lista";
    }
}