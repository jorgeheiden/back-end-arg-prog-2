
package com.backendargprog.backendargprog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Trabajo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private Long idTrab;
    private String imagenTrab;
    private String nombreTrab;
    private String descripcionTrab;

    public Trabajo(){}
    
    public Trabajo(Long idTrab,String imagenTrab, String nombreTrab, String descripcionTrab) {
        this.idTrab = idTrab;
        this.imagenTrab= imagenTrab;
        this.nombreTrab = nombreTrab;
        this.descripcionTrab = descripcionTrab;
    }
}
