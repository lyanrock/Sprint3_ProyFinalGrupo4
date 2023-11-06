package com.GrupoUDEA.proyFinalSprint3.Controllers;

import com.GrupoUDEA.proyFinalSprint3.Entities.Movimiento;
import com.GrupoUDEA.proyFinalSprint3.Entities.Usuario;
import com.GrupoUDEA.proyFinalSprint3.Services.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
public class MovimientoController {
    @Autowired
    private MovimientoService movimientoService;

    @GetMapping("/consultarmovimiento")
    public List<Movimiento> getMovimientos(){
        return movimientoService.getMovimiento();
    }

    @GetMapping("/consultarmovimiento/{id}")
    public Movimiento getMovimientos(@PathVariable Integer id){
        return movimientoService.getMovimiento(id);
    }

    @PostMapping("/crearmovto")
    public RedirectView createMovimiento(@ModelAttribute Movimiento movimiento, Model model){
        model.addAttribute(movimiento);
        movimientoService.saveMovimiento(movimiento);
        return new RedirectView("/movimientos");
    }
    @PutMapping("/modificarmovto")
    public RedirectView updateMovimiento(@ModelAttribute Movimiento movimiento){
        movimientoService.updateMovimiento(movimiento);
        return new RedirectView("/movimientos");
    }

    @DeleteMapping("/eliminarmovimiento/{id}")
    public RedirectView deleteMovimiento(@PathVariable Integer id){
        movimientoService.deleteMovimiento(id);
        return  new RedirectView("/movimientos");
    }

    @PatchMapping()
    public RedirectView updateEstado(@PathVariable("id") Integer id){
        movimientoService.estadoMovimiento(id);
        return  new RedirectView("/movimientos");
    }
}
