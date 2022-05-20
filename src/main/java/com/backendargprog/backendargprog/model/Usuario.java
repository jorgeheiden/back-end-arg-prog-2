package com.backendargprog.backendargprog.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter @Setter
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String nombre;
    private String apellido;
    private String presentacion;

    //Vincular la entidad Usuario con Educacion y proyectos:
    //Es una relacion de uno a muchos (One to Many)
    //Se especifica un fetch de tipo LAZY para no traer toda la informacion, sino solo la requerida
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idEdu")
    private List<Educacion> educacionList;

    //Se mapea por el id => (mappedBy = "idProy")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idProy")
    private List<Proyectos> proyectosList;

    public Usuario(){

    }

    public Usuario(Long id, String nombre, String apellido, String presentacion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.presentacion = presentacion;
    }


}
