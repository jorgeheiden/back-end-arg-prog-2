
package com.backendargprog.backendargprog.services;

import com.backendargprog.backendargprog.model.Habilidad;
import com.backendargprog.backendargprog.repository.HabilidadRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HabilidadService {
    
    private final HabilidadRepo habilidadRepo;
    @Autowired
    
    public HabilidadService(HabilidadRepo habilidadRepo) {
        this.habilidadRepo = habilidadRepo;
    }
    public Habilidad crearHabilidad(Habilidad habilidad){
        return habilidadRepo.save(habilidad);
    }
    public List<Habilidad> verHabilidad(){
        return habilidadRepo.findAll();
    }
    public Habilidad editarHabilidad(Habilidad habilidad){
        return habilidadRepo.save(habilidad);
    }
    public void borrarHabilidad(Long id){
        habilidadRepo.deleteById(id);
    }
    public Habilidad buscarHabilidadPorId(Long id){
        return habilidadRepo.findById(id).orElse(null);
    }

    public List<Habilidad> verTodosLosHabilidad(){
        return habilidadRepo.findAll();
    }
}
