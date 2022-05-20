package com.backendargprog.backendargprog.controller;

import com.backendargprog.backendargprog.model.Educacion;
import com.backendargprog.backendargprog.model.Usuario;
import com.backendargprog.backendargprog.services.EducacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/educacion")

public class EducacionController {

    private final EducacionService educacionService;

    public EducacionController(EducacionService educacionService) {
        this.educacionService = educacionService;
    }

    @GetMapping("/idEdu/{idEdu}")
    //5)ResponseEntity: devuelve una respuesta http indicada
    public ResponseEntity<Educacion> obtenerEducacion(@PathVariable("idEdu") Long id){
        Educacion educacion=educacionService.buscarEducacionPorId(id);
        return new ResponseEntity<>(educacion, HttpStatus.OK);
    }
    // **METODO PUT**
    @PutMapping("/update")
    public ResponseEntity<Educacion> editarEducacion(@RequestBody Educacion educacion){
        Educacion actualizarEducacion= educacionService.editarEducacion(educacion);
        return new ResponseEntity<>(actualizarEducacion,HttpStatus.OK);
    }
    @PostMapping("/nuevo")
    public ResponseEntity<Educacion> crearEducacion(@RequestBody Educacion educacion){
        Educacion agregarEducacion= educacionService.crearEducacion(educacion);
        return new ResponseEntity<>(agregarEducacion, HttpStatus.OK);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> borrarEducacion(@PathVariable("id") Long id){
        educacionService.borrarEducacion(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("ver/educaciones")
    public ResponseEntity<List<Educacion>> obtenerEducacion(){
        List<Educacion> educacion=educacionService.verTodasLasEducaciones();
        return new ResponseEntity<>(educacion, HttpStatus.OK);
    }

}
