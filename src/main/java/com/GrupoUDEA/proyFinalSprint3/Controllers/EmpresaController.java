package com.GrupoUDEA.proyFinalSprint3.Controllers;

import com.GrupoUDEA.proyFinalSprint3.Entities.Empresa;
import com.GrupoUDEA.proyFinalSprint3.Services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
public class EmpresaController {
    @Autowired
    private EmpresaService empresaService;

    @GetMapping("/consultarempresa")
    public List<Empresa> getEmpresas(){
        return empresaService.getEmpresa();
    }

    @GetMapping("/consultarempresa/{id}")
    public Empresa getEmpresas(@PathVariable Integer id){
        return empresaService.getEmpresa(id);
    }

    @PostMapping("/crearempresa")
    public RedirectView createEmpresa(@ModelAttribute Empresa empresa, Model model){
        model.addAttribute(empresa);
        empresaService.saveEmpresas(empresa);
        return new RedirectView("/empresas");
    }

    @PostMapping("/modificarempresa")
    public RedirectView updateEmpresa(@ModelAttribute Empresa empresa){
        empresaService.updateEmpresa(empresa);
        return new RedirectView("/empresas");
    }

    @DeleteMapping("/eliminarempresa/{id}")
    public RedirectView deleteEmpresa(@PathVariable Integer id){
        empresaService.deleteEmpresa(id);
        return  new RedirectView("/empresas");
    }
    @PatchMapping("/empresas/{id}")
    public RedirectView updateEstado(@PathVariable("id") Integer id){
        empresaService.estadoEmpresas(id);
        return new RedirectView("/empresas");
    }


}
