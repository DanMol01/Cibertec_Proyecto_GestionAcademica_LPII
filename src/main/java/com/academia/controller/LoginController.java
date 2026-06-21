package com.academia.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.academia.entity.UsuarioSistema;
import com.academia.service.UsuarioService;
@Controller

@RequestMapping("/gestionlogin")
public class LoginController {
	
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String login() {
    	return "login/loginPage";
    }

    @PostMapping("/login")
    public String validarLogin(@RequestParam String usuario,
                               @RequestParam String clave,
                               HttpSession session,
                               Model model) {

        UsuarioSistema usuarioEncontrado = usuarioService.validarLogin(usuario, clave);

        if (usuarioEncontrado != null) {
            session.setAttribute("usuarioLogueado", usuarioEncontrado);
            return "redirect:/gestionlogin/menu";
        }

        model.addAttribute("error", "UsuarioSistema o contraseña incorrectos");
        return "login/loginPage";
    }

    @GetMapping("/menu")
    public String menu(HttpSession session) {
        if (session.getAttribute("usuarioLogueado") == null) {
            return "redirect:/gestionlogin/login";
        }

        return "menu/menu";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/gestionlogin/login";
    }

}
