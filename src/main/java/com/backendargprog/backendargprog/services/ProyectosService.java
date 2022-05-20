package com.backendargprog.backendargprog.services;

import com.backendargprog.backendargprog.model.Educacion;
import com.backendargprog.backendargprog.model.Proyectos;
import com.backendargprog.backendargprog.model.Usuario;
import com.backendargprog.backendargprog.repository.ProyectosRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProyectosService {
    private final ProyectosRepo proyectosRepo;
    @Autowired
    public ProyectosService(ProyectosRepo proyectosRepo) {
        this.proyectosRepo = proyectosRepo;
    }
    public Proyectos crearProyectos(Proyectos proyectos){
        return proyectosRepo.save(proyectos);
    }
    public List<Proyectos> verProyectos(){
        return proyectosRepo.findAll();
    }
    public Proyectos editarProyectos(Proyectos proyectos){
        return proyectosRepo.save(proyectos);
    }
    public void borrarProyectos(Long id){
        proyectosRepo.deleteById(id);
    }
    public Proyectos buscarProyectosPorId(Long id){
        return proyectosRepo.findById(id).orElse(null);
    }

    public List<Proyectos> verTodosLosProyectos(){
        return proyectosRepo.findAll();
    }
}
