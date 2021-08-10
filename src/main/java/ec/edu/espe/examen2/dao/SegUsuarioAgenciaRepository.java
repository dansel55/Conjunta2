package ec.edu.espe.examen2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.espe.examen2.model.SegUsuarioAgencia;

public interface SegUsuarioAgenciaRepository extends JpaRepository<SegUsuarioAgencia, String> {
    
}
