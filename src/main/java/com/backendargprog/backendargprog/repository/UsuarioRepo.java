package com.backendargprog.backendargprog.repository;

import com.backendargprog.backendargprog.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

//1) Hacer que cada Interfaz extidenda de JpaRepository: extends JpaRepository
//2) Indicar con que entidad se va a trabajar y el tipo de dato del id: <Usuario, Long>
public interface UsuarioRepo extends JpaRepository <Usuario, Long> {
}
