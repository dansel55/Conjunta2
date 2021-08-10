package ec.edu.espe.examen2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.examen2.model.GenAgencia;
import ec.edu.espe.examen2.service.GenAgenciaService;

@RestController
@RequestMapping("/api/agencia")
public class AgenciaController {
    @Autowired
    private GenAgenciaService genAgenciaService;

    @GetMapping("/empresa/{codEmpresa}")
    public ResponseEntity<List<GenAgencia>> obtenerAgenciasPorEmpresa(@PathVariable String codEmpresa) {
        return ResponseEntity.ok(this.genAgenciaService.obtenerAgenciasPorEmpresa(codEmpresa));
    }
}
