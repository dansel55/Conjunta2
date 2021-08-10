package ec.edu.espe.examen2.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegistrarUsuarioDto {
    String codUsuario;
    String nombre;
    String identificacion;
    String email;
    String estado;
    List<String> agencias;
}
