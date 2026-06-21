package com.academia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.academia.entity.Horario;
import com.academia.service.HorarioService;

@Controller
@RequestMapping("/gestionhorario")
public class HorarioController {

    @Autowired
    private HorarioService horarioService;

    @GetMapping("/lista")
    public String listarHorarios(Model model) {
        model.addAttribute("horarios", horarioService.listar());
        model.addAttribute("horario", new Horario());
        model.addAttribute("vista", "horarios");
        return "menu/menu";
    }

    @PostMapping("/registrar")
    public String registrar(Horario horario) {
        horarioService.registrar(horario);
        return "redirect:/gestionhorario/lista";
    }

    @PostMapping("/actualizar")
    public String actualizar(Horario horario) {
        horarioService.actualizar(horario);
        return "redirect:/gestionhorario/lista";
    }

    @GetMapping("/buscar/{id}")
    @ResponseBody
    public Horario buscar(@PathVariable int id) {
        return horarioService.buscarPorId(id);
    }

    @GetMapping("/desactivar/{id}")
    public String desactivar(@PathVariable int id) {
        horarioService.desactivar(id);
        return "redirect:/gestionhorario/lista";
    }
}
