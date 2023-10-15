package com.GrupoUDEA.proyFinalSprint3.Services;
import com.GrupoUDEA.proyFinalSprint3.Entities.Empresa;
import com.GrupoUDEA.proyFinalSprint3.Repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {
    @Autowired
    private EmpresaRepository empresaRepository;

    public List<Empresa> getEmpresa(){
        return empresaRepository.findAll();
    }

    public Empresa getEmpresa(Integer id){
        return empresaRepository.findById(id).orElse(null);
    }

    public List<Empresa> saveEmpresas(List<Empresa> empresa){
        return empresaRepository.saveAll(empresa);
    }

    public Empresa updateEmpresa(Empresa empresa){
        Empresa existeEmpresa = empresaRepository.findById(empresa.getId()).orElse(null)   ;
        existeEmpresa.setNombre(empresa.getNombre());
        existeEmpresa.setNit(empresa.getNit());
        existeEmpresa.setDireccion(empresa.getDireccion());
        existeEmpresa.setTelefono(empresa.getTelefono());
        return empresaRepository.save(existeEmpresa);
    }
    public String deleteEmpresa(Integer id){
        empresaRepository.deleteById(id);
        return "Has Eliminado la empresa ID " + id;
    }

}
