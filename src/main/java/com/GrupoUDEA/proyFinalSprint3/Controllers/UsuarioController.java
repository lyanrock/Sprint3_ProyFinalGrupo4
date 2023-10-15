package com.GrupoUDEA.proyFinalSprint3.Controllers;

import com.GrupoUDEA.proyFinalSprint3.Entities.Usuario;
import com.GrupoUDEA.proyFinalSprint3.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/empresa")
@RestController
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/consultar")
    public List<Usuario> getUsuarios(){
        return usuarioService.getUsuario();
    }


    @GetMapping("/consultar/{id}")
    public Usuario getUsuarios(@PathVariable Integer id){
        return usuarioService.getUsuario(id);
    }

    @PostMapping("/crear")
    public List<Usuario> createUsuario(@RequestBody List<Usuario> usuario){
        return usuarioService.saveUsuario(usuario);
    }

    @PutMapping("/modificar")
    public Usuario updateUsuario(@RequestBody Usuario usuario) {
        return usuarioService.updateUsuario(usuario);
    }

    @DeleteMapping("/eliminar/{id}")
    public String deleteUsuario(@PathVariable Integer id){

        return  usuarioService.deleteUsuario(id);
    }
}
