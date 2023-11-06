package com.GrupoUDEA.proyFinalSprint3.Services;

import com.GrupoUDEA.proyFinalSprint3.Entities.Empresa;
import com.GrupoUDEA.proyFinalSprint3.Entities.Movimiento;
import com.GrupoUDEA.proyFinalSprint3.Repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovimientoService {
    @Autowired
    private MovimientoRepository movimientoRepository;

    public List<Movimiento> getMovimiento(){
        return movimientoRepository.findAll();
    }

    public Movimiento getMovimiento(Integer id){
        return movimientoRepository.findById(id).orElse(null);
    }

    public Movimiento saveMovimiento (Movimiento movimiento){
        return movimientoRepository.save(movimiento);
    }

    public Movimiento updateMovimiento(Movimiento movimiento){
        Movimiento existeMovimiento = movimientoRepository.findById(movimiento.getId()).orElse(null)   ;
        existeMovimiento.setMonto(movimiento.getMonto());
        existeMovimiento.setConcepto(movimiento.getConcepto());
        existeMovimiento.setUsuario(movimiento.getUsuario());
        existeMovimiento.setFecha(movimiento.getFecha());
        existeMovimiento.setEstado(movimiento.isEstado());
        return movimientoRepository.save(existeMovimiento);
    }
    public String deleteMovimiento(Integer id){
        movimientoRepository.deleteById(id);
        return "Has Eliminado el movimiento ID " + id;
    }

    public boolean estadoMovimiento(Integer id){
        Movimiento movimiento = movimientoRepository.findById(id).orElse(null);
        if(movimiento != null){
            if(movimiento.isEstado()){
                movimiento.setEstado(false);
                movimientoRepository.save(movimiento);
                return true;
            }else{
                movimiento.setEstado(true);
                movimientoRepository.save(movimiento);
                return true;
            }
        }
        return false;
    }
}
