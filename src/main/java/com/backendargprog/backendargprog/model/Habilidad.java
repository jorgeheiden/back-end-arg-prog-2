
package com.backendargprog.backendargprog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Habilidad {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private Long idHab;
    private String imagenHab;
    private String nombreHab;
    
    public Habilidad(){

    }

    public Habilidad(Long idHab, String imagenHab, String nombreHab) {
        this.idHab = idHab;
        this.imagenHab = imagenHab;
        this.nombreHab = nombreHab;
        
    }
    
}
