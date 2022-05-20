package com.backendargprog.backendargprog.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter @Setter
@Entity
public class Educacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long idEdu;
    private String tituloEdu;
    private String institucionEdu;

    public Educacion(){}

    public Educacion(Long idEdu, String tituloEdu, String institucionEdu) {
        this.idEdu = idEdu;
        this.tituloEdu = tituloEdu;
        this.institucionEdu = institucionEdu;
    }
}
