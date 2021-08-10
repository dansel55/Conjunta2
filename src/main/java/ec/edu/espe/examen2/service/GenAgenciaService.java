package ec.edu.espe.examen2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.espe.examen2.dao.GenAgenciaRepository;
import ec.edu.espe.examen2.model.GenAgencia;

@Service
public class GenAgenciaService {
    @Autowired
    private GenAgenciaRepository genAgenciaRepository;

    public List<GenAgencia> obtenerAgenciasPorEmpresa(String codEmpresa) {
        return this.genAgenciaRepository.findByPkCodEmpresa(codEmpresa);
    }
}
