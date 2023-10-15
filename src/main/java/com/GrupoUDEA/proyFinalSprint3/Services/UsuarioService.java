package com.GrupoUDEA.proyFinalSprint3.Services;

import com.GrupoUDEA.proyFinalSprint3.Entities.Usuario;
import com.GrupoUDEA.proyFinalSprint3.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getUsuario(){
        return usuarioRepository.findAll();
    }

    public Usuario getUsuario(Integer id){
        return usuarioRepository.findById(id).orElse(null);
    }

    public List<Usuario> saveUsuario(List<Usuario> usuario){
        return usuarioRepository.saveAll(usuario);
    }

    public Usuario updateUsuario(Usuario usuario){
        Usuario existeUsuario = usuarioRepository.findById(usuario.getId()).orElse(null)   ;
        existeUsuario.setNombre(usuario.getNombre());
        existeUsuario.setDocumento(usuario.getDocumento());
        existeUsuario.setCorreo(usuario.getCorreo());
        existeUsuario.setTelefono(usuario.getTelefono());
        existeUsuario.setEmpresa(usuario.getEmpresa());
        existeUsuario.setRol(usuario.getRol());
        return usuarioRepository.save(existeUsuario);
    }
    public String deleteUsuario(Integer id){
        usuarioRepository.deleteById(id);
        return "Has Eliminado el usuario ID " + id;
    }
}
