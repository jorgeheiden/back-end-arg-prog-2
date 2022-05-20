package com.backendargprog.backendargprog.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter @Setter
@Entity
public class Proyectos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long idProy;
    private String imagenProy;
    private String nombreProy;
    private String linkProy;

    public Proyectos(){

    }

    public Proyectos(Long idProy, String imagenProy, String nombreProy, String linkProy) {
        this.idProy = idProy;
        this.imagenProy = imagenProy;
        this.nombreProy = nombreProy;
        this.linkProy = linkProy;
    }
}
