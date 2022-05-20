package com.backendargprog.backendargprog.controller;

import com.backendargprog.backendargprog.model.Usuario;
import com.backendargprog.backendargprog.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Anotacion que solucionaria el problema con cors
@CrossOrigin(origins = "*")

//1) Anotacion que indica que es un controlador @RestController
@RestController
//2) Se indica la URL
@RequestMapping("/usuario")
public class UsuarioController {
    //3) Se crea el servicio. mouse sobre esta linea: add constructor
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    //  **METODO GET por id**
    //4)Getmapping => en la direccion que se indica, trae el usuario
    @GetMapping("/id/{id}")
    //5)ResponseEntity: devuelve una respuesta http indicada
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable("id") Long id){
        Usuario usuario=usuarioService.buscarUsuarioPorId(id);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }
    // **METODO GET obtener todos**
    @GetMapping("ver/usuarios")
    public ResponseEntity<List<Usuario>> obtenerUsuario(){
        List<Usuario> usuarios=usuarioService.verTodosLosUsuarios();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }
    // **METODO PUT**
    @PutMapping("/update")
    public ResponseEntity<Usuario> editarUsuario(@RequestBody Usuario usuario){
        Usuario actualizarUsuario= usuarioService.editarUsuario(usuario);
        return new ResponseEntity<>(actualizarUsuario,HttpStatus.OK);
    }
    // **METODO POST**
    @PostMapping("/nuevo")
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario){
        Usuario agregarUsuario= usuarioService.crearUsuario(usuario);
        return new ResponseEntity<>(agregarUsuario, HttpStatus.OK);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> borrarUsuario(@PathVariable("id") Long id){
        usuarioService.borrarUsuario(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
