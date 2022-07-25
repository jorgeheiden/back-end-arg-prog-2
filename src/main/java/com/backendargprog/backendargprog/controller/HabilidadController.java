
package com.backendargprog.backendargprog.controller;

import com.backendargprog.backendargprog.model.Habilidad;
import com.backendargprog.backendargprog.model.Proyectos;
import com.backendargprog.backendargprog.services.HabilidadService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/habilidad")
public class HabilidadController {
    
    private final HabilidadService habilidadService;

    public HabilidadController(HabilidadService habilidadService) {
        this.habilidadService = habilidadService;
    }
    @GetMapping("/idHab/{idHab}")
    public ResponseEntity<Habilidad> obtenerHabilidad(@PathVariable("idHab") Long id){
        Habilidad habilidad=habilidadService.buscarHabilidadPorId(id);
        return new ResponseEntity<>(habilidad, HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Habilidad> editarHabilidad(@RequestBody Habilidad habilidad){
        Habilidad actualizarHabilidad= habilidadService.editarHabilidad(habilidad);
        return new ResponseEntity<>(actualizarHabilidad,HttpStatus.OK);
    }
    @PostMapping("/nuevo")
    public ResponseEntity<Habilidad> crearHabilidad(@RequestBody Habilidad habilidad){
        Habilidad agregarHabilidad= habilidadService.crearHabilidad(habilidad);
        return new ResponseEntity<>(agregarHabilidad, HttpStatus.OK);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> borrarHabilidad(@PathVariable("id") Long id){
        habilidadService.borrarHabilidad(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("ver/habilidades")
    public ResponseEntity<List<Habilidad>> obtenerHabilidad(){
        List<Habilidad> habilidad=habilidadService.verTodosLosHabilidad();
        return new ResponseEntity<>(habilidad, HttpStatus.OK);
    }
}
