package ec.edu.espe.examen2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.examen2.dto.RegistrarUsuarioDto;
import ec.edu.espe.examen2.service.SegUsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    @Autowired
    private SegUsuarioService segUsuarioService;

    @PostMapping
    public ResponseEntity<?> registrarUsuario(@RequestBody RegistrarUsuarioDto registrarUsuarioDto) {
        try {
            return ResponseEntity.ok(this.segUsuarioService.crearUsuario(registrarUsuarioDto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    } 
}
