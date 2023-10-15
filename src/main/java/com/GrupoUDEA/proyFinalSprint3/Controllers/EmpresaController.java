package com.GrupoUDEA.proyFinalSprint3.Controllers;

import com.GrupoUDEA.proyFinalSprint3.Entities.Empresa;
import com.GrupoUDEA.proyFinalSprint3.Services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/empresa")
@RestController
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping("/consultar")
    public List<Empresa> getEmpresas(){
        return empresaService.getEmpresa();
    }


    @GetMapping("/consultar/{id}")
    public Empresa getEmpresas(@PathVariable Integer id){
        return empresaService.getEmpresa(id);
    }

    @PostMapping("/crear")
    public List<Empresa> createEmpresa(@RequestBody List<Empresa> empresa){
        return empresaService.saveEmpresas(empresa);
    }

    @PutMapping("/modificar")
    public Empresa updateEmpresa(@RequestBody Empresa empresa){
        return empresaService.updateEmpresa(empresa);
    }



    @DeleteMapping("/eliminar/{id}")
    public String deleteEmpresa(@PathVariable Integer id){

        return  empresaService.deleteEmpresa(id);
    }
}
