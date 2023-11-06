package com.GrupoUDEA.proyFinalSprint3.Controllers;

import com.GrupoUDEA.proyFinalSprint3.Entities.Empresa;
import com.GrupoUDEA.proyFinalSprint3.Entities.Usuario;
import com.GrupoUDEA.proyFinalSprint3.Entities.Movimiento;
import com.GrupoUDEA.proyFinalSprint3.Services.EmpresaService;
import com.GrupoUDEA.proyFinalSprint3.Services.MovimientoService;
import com.GrupoUDEA.proyFinalSprint3.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class FrontController {
    @Autowired
    EmpresaService empresaService;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    MovimientoService movimientoService;

    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal OidcUser principal) {
        if (principal != null) {
            model.addAttribute("profile", principal.getClaims());
        }
        return "index";
    }
    @GetMapping("/empresas")
    public String empresa(Model model){
        List<Empresa> empresas = empresaService.getEmpresa();
        model.addAttribute("empresa", empresas);
        return "empresa";
    }

    @GetMapping("/usuarios")
    public String usuario(Model model){
        List<Usuario> usuarios = usuarioService.getUsuarios();
        model.addAttribute("usuario", usuarios);
        return "usuario";
    }

    @GetMapping("/movimientos")
    public String movimiento(Model model){
        List<Movimiento> movimientos = movimientoService.getMovimiento();
        model.addAttribute("movimiento", movimientos);
        return "movimiento";
    }

    @GetMapping("/empresas/añadir")
    public String newEmpresa(Model model){
        model.addAttribute("empresa", new Empresa());
        return "newEmpresa";
    }

    @GetMapping("/usuarios/añadir")
    public String newUsuario(Model model){
        model.addAttribute("usuario", new Usuario());
        return "newUsuario";
    }

    @GetMapping("/movimientos/añadir")
    public String newMovimiento(Model model){
        model.addAttribute("movimiento", new Movimiento());
        return "newMovimiento";
    }
    @GetMapping("/empresas/editar/{id}")
    public String editEmpresa(@PathVariable Integer id,  Model model){
        Empresa empresa = empresaService.getEmpresa(id);
        if(empresa != null){
            model.addAttribute("empresa", empresa);
            return "/editEmpresa";
        }
        return "redirect:/empresas";
    }

    @GetMapping("/usuarios/editar/{id}")
    public String editUsuario(@PathVariable Integer id,  Model model){
        Usuario usuario = usuarioService.getUsuario(id);
        if(usuario != null){
            model.addAttribute("usuario", usuario);
            return "/editUsuario";
        }
        return "redirect:/usuarios";
    }

    @GetMapping("/movimientos/editar/{id}")
    public String editMovimiento(@PathVariable Integer id,  Model model){
        Movimiento movimiento = movimientoService.getMovimiento(id);
        if(movimiento != null){
            model.addAttribute("movimiento", movimiento);
            return "/editmovimiento";
        }
        return "redirect:/movimientos";
    }

    @GetMapping("/inicio")
    public String inicio(Model model){
        return "inicio";
    }


}
