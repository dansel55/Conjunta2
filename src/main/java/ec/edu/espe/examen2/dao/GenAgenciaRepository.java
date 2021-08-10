package ec.edu.espe.examen2.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.espe.examen2.model.GenAgencia;
import java.util.Optional;

public interface GenAgenciaRepository extends JpaRepository<GenAgencia, String> {
    public List<GenAgencia> findByPkCodEmpresa(String codEmpresa);
    public Optional<GenAgencia> findByPkCodAgencia(String codEmpresa);
}


