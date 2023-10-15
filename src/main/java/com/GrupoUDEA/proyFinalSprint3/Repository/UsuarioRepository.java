package com.GrupoUDEA.proyFinalSprint3.Repository;

import com.GrupoUDEA.proyFinalSprint3.Entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
