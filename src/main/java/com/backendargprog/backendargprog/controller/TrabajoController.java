
package com.backendargprog.backendargprog.controller;

import com.backendargprog.backendargprog.model.Trabajo;
import com.backendargprog.backendargprog.services.TrabajoService;
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
@RequestMapping("/trabajo")
public class TrabajoController {
    private final TrabajoService trabajoService;
    
    public TrabajoController(TrabajoService trabajoService) {
        this.trabajoService = trabajoService;
    }
    @GetMapping("/idTrab/{idTrab}")
    public ResponseEntity<Trabajo> obtenerTrabajo(@PathVariable("idTrab") Long id){
        Trabajo trabajo=trabajoService.buscarTrabajoPorId(id);
        return new ResponseEntity<>(trabajo, HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Trabajo> editarTrabajo(@RequestBody Trabajo trabajo){
        Trabajo actualizarTrabajo= trabajoService.editarTrabajo(trabajo);
        return new ResponseEntity<>(actualizarTrabajo,HttpStatus.OK);
    }
    @PostMapping("/nuevo")
    public ResponseEntity<Trabajo> crearTrabajo(@RequestBody Trabajo trabajo){
        Trabajo agregarTrabajo= trabajoService.crearTrabajo(trabajo);
        return new ResponseEntity<>(agregarTrabajo, HttpStatus.OK);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> borrarTrabajo(@PathVariable("id") Long id){
        trabajoService.borrarTrabajo(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("ver/trabajos")
    public ResponseEntity<List<Trabajo>> obtenerTrabajos(){
        List<Trabajo> trabajo=trabajoService.verTodosLosTrabajos();
        return new ResponseEntity<>(trabajo, HttpStatus.OK);
    }
}
