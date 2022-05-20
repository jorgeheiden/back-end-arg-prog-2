package com.backendargprog.backendargprog.services;

import com.backendargprog.backendargprog.model.Educacion;
import com.backendargprog.backendargprog.model.Usuario;
import com.backendargprog.backendargprog.repository.EducacionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//1) Anotacion que indica que esto es un Servicio:
@Service

//2) Anotacion para la implementacion de los metodos y union con el controlador: @Transactional
// **Importante** importar de: import org.springframework.transaction.annotation.Transactional;
@Transactional

public class EducacionService {
    //3)crear instancia con el repositorio: private final UsuarioRepo usuarioRepo;
    //4) mouse sobre esta linea y seleccionar: add constructor parameter
    private final EducacionRepo educacionRepo;

    //5) Agregar la anotacion @Autowired que hace la inyeccion de dependencias
    @Autowired
    public EducacionService(EducacionRepo educacionRepo) {
        this.educacionRepo = educacionRepo;
    }

    //6) Crear los metodos:
    //a) post
    public Educacion crearEducacion(Educacion educacion){
        return educacionRepo.save(educacion);
    }
    //b)
    public List<Educacion> buscarEducaciones(){
        return educacionRepo.findAll();
    }
    //c) put
    public Educacion editarEducacion(Educacion educacion){
        return educacionRepo.save(educacion);
    }
    //d) delete
    public void borrarEducacion(Long id){
        educacionRepo.deleteById(id);
    }
    //e) Get
    public Educacion buscarEducacionPorId(Long id){
        return educacionRepo.findById(id).orElse(null);
    }
    public List<Educacion> verTodasLasEducaciones(){
        return educacionRepo.findAll();
    }


}

