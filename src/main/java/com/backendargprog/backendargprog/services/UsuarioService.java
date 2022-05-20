package com.backendargprog.backendargprog.services;


import com.backendargprog.backendargprog.model.Usuario;
import com.backendargprog.backendargprog.repository.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//1) Anotacion que indica que esto es un Servicio:
@Service

//2) Anotacion para la implementacion de los metodos y union con el controlador
// **Importante** importar de: import org.springframework.transaction.annotation.Transactional;
@Transactional
public class UsuarioService {
    //3)crear instancia con el repositorio: private final UsuarioRepo usuarioRepo;
    //4) mouse sobre esta linea y seleccionar: add constructor parameter
    private final UsuarioRepo usuarioRepo;

    //5) Agregar la anotacion @Autowired que hace la inyeccion de dependencias
    @Autowired
    public UsuarioService(UsuarioRepo usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    //6) Crear los metodos:
    //a) POST
    public Usuario crearUsuario(Usuario usuario){
        return usuarioRepo.save(usuario);
    }

    //b)GET para ver todos los usuarios
    public List<Usuario> verTodosLosUsuarios(){
        return usuarioRepo.findAll();
    }
    //c) PUT
    public Usuario editarUsuario(Usuario usuario){
        return usuarioRepo.save(usuario);
    }
    //d) delete
    public void borrarUsuario(Long id){
        usuarioRepo.deleteById(id);
    }

    //e) Get

  public Usuario buscarUsuarioPorId(Long id){
        return usuarioRepo.findById(id).orElse(null);
    }
}