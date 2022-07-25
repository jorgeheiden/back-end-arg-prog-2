
package com.backendargprog.backendargprog.services;

import com.backendargprog.backendargprog.model.Trabajo;
import com.backendargprog.backendargprog.repository.TrabajoRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TrabajoService {
    private final TrabajoRepo trabajoRepo;
    
    @Autowired
    
    public TrabajoService(TrabajoRepo trabajoRepo) {
        this.trabajoRepo = trabajoRepo;
    }
    public Trabajo crearTrabajo(Trabajo trabajo){
        return trabajoRepo.save(trabajo);
    }
    public List<Trabajo> verTrabajo(){
        return trabajoRepo.findAll();
    }
    public Trabajo editarTrabajo(Trabajo trabajo){
        return trabajoRepo.save(trabajo);
    }
    public void borrarTrabajo(Long id){
        trabajoRepo.deleteById(id);
    }
    public Trabajo buscarTrabajoPorId(Long id){
        return trabajoRepo.findById(id).orElse(null);
    }

    public List<Trabajo> verTodosLosTrabajos(){
        return trabajoRepo.findAll();
    }
}
