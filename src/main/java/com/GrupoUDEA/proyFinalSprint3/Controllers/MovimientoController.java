package com.GrupoUDEA.proyFinalSprint3.Controllers;

import com.GrupoUDEA.proyFinalSprint3.Entities.Movimiento;
import com.GrupoUDEA.proyFinalSprint3.Repository.MovimientoRepository;
import com.GrupoUDEA.proyFinalSprint3.Services.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/movimiento")
@RestController
public class MovimientoController {
    @Autowired
    private MovimientoService movimientoService;

    @GetMapping("/consultar")
    public List<Movimiento> getMovimientos(){
        return movimientoService.getMovimiento();
    }

    @GetMapping("/consultar/{id}")
    public Movimiento getMovimientos(@PathVariable Integer id){
        return movimientoService.getMovimiento(id);
    }

    @PostMapping("/crear")
    public List<Movimiento> createMovimiento(@RequestBody List<Movimiento> movimiento){
        return movimientoService.saveMovimiento(movimiento);
    }

    @PutMapping("/modificar")
    public Movimiento updateEmpresa(@RequestBody Movimiento movimiento){
        return movimientoService.updateMovimiento(movimiento);
    }

    @DeleteMapping("/eliminar/{id}")
    public String deleteMovimiento(@PathVariable Integer id){

        return  movimientoService.deleteMovimiento(id);
    }
}
