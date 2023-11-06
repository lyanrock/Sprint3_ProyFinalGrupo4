package com.GrupoUDEA.proyFinalSprint3.Controllers;

import com.GrupoUDEA.proyFinalSprint3.Entities.Usuario;
import com.GrupoUDEA.proyFinalSprint3.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/consultarusuario")
    public List<Usuario> getUsuarios(){
        return usuarioService.getUsuarios();
    }


    @GetMapping("/consultarusuario/{id}")
    public Usuario getUsuario(@PathVariable Integer id){
        return usuarioService.getUsuario(id);
    }

    @PostMapping("/crearusuario")
    public RedirectView createUsuario(@ModelAttribute Usuario usuario, Model model){
        model.addAttribute(usuario);
        usuarioService.saveUsuario(usuario);
        return new RedirectView("/usuarios");
    }

    @PostMapping("/modificarusuario")
    public RedirectView updateUsuario(@ModelAttribute Usuario usuario) {
        usuarioService.updateUsuario(usuario);
        return new RedirectView("/usuarios");
    }

    @DeleteMapping("/eliminarusuario/{id}")
    public RedirectView deleteUsuario(@PathVariable Integer id){
        usuarioService.deleteUsuario(id);
        return new RedirectView("/usuarios");
    }

    @PatchMapping("/usuarios/{id}")
    public RedirectView updateEstado(@PathVariable("id") Integer id){
        usuarioService.estadoUsuarios(id);
        return new RedirectView("/usuarios");
    }
}

