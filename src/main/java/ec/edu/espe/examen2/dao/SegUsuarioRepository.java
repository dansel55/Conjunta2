package ec.edu.espe.examen2.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.espe.examen2.model.SegUsuario;

public interface SegUsuarioRepository extends JpaRepository<SegUsuario, String> {
    Optional<SegUsuario> findByIdentificacion(String identificacion);
}
