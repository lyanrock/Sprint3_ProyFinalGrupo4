package com.GrupoUDEA.proyFinalSprint3.Services;

import com.GrupoUDEA.proyFinalSprint3.Entities.Usuario;
import com.GrupoUDEA.proyFinalSprint3.Repository.UsuarioRepository;
//import com.GrupoUDEA.proyFinalSprint3.Entities.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Configurable
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getUsuarios(){
        return usuarioRepository.findAll();
    }

    public Usuario getUsuario(Integer id){
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario saveUsuario(Usuario usuario){

        return usuarioRepository.save(usuario);
    }

    public Usuario updateUsuario(Usuario usuario){
        Usuario existeUsuario = usuarioRepository.findById(usuario.getId()).orElse(null)   ;
        existeUsuario.setNombre(usuario.getNombre());
        existeUsuario.setDocumento(usuario.getDocumento());
        existeUsuario.setCorreo(usuario.getCorreo());
        existeUsuario.setTelefono(usuario.getTelefono());
        existeUsuario.setEmpresa(usuario.getEmpresa());
        existeUsuario.setRol(usuario.getRol());
        existeUsuario.setEstado(usuario.isEstado());
        return usuarioRepository.save(existeUsuario);
    }
    public String deleteUsuario(Integer id){
        usuarioRepository.deleteById(id);
        return "Has Eliminado el usuario ID " + id;
    }

    public boolean estadoUsuarios(Integer id){
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if(usuario != null){
            if(usuario.isEstado()){
                usuario.setEstado(false);
                usuarioRepository.save(usuario);
                return true;
            }else{
                usuario.setEstado(true);
                usuarioRepository.save(usuario);
                return true;
            }
        }
        return false;
    }
}