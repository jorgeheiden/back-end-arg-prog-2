package com.backendargprog.backendargprog.controller;

import com.backendargprog.backendargprog.model.Educacion;
import com.backendargprog.backendargprog.model.Proyectos;
import com.backendargprog.backendargprog.model.Usuario;
import com.backendargprog.backendargprog.services.ProyectosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/proyectos")
public class ProyectosController {

    private final ProyectosService proyectosService;

    public ProyectosController(ProyectosService proyectosService) {
        this.proyectosService = proyectosService;
    }
    @GetMapping("/idProy/{idProy}")
    public ResponseEntity<Proyectos> obtenerProyectos(@PathVariable("idProy") Long id){
        Proyectos proyectos=proyectosService.buscarProyectosPorId(id);
        return new ResponseEntity<>(proyectos, HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Proyectos> editarProyectos(@RequestBody Proyectos proyectos){
        Proyectos actualizarProyectos= proyectosService.editarProyectos(proyectos);
        return new ResponseEntity<>(actualizarProyectos,HttpStatus.OK);
    }
    @PostMapping("/nuevo")
    public ResponseEntity<Proyectos> crearProyectos(@RequestBody Proyectos proyectos){
        Proyectos agregarProyectos= proyectosService.crearProyectos(proyectos);
        return new ResponseEntity<>(agregarProyectos, HttpStatus.OK);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> borrarProyectos(@PathVariable("id") Long id){
        proyectosService.borrarProyectos(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("ver/proyectos")
    public ResponseEntity<List<Proyectos>> obtenerProyectos(){
        List<Proyectos> proyectos=proyectosService.verTodosLosProyectos();
        return new ResponseEntity<>(proyectos, HttpStatus.OK);
    }
}
