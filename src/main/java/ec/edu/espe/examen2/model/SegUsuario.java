package ec.edu.espe.examen2.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "SEG_USUARIO")
public class SegUsuario {
    @Id
    @Column(name = "cod_usuario", length = 30)
    String codUsuario;

    @Column(name = "nombre", length = 150)
    String nombre;

    @Column(name = "identificacion", length = 30)
    String identificacion;

    @Column(name = "email", length = 250)
    String email;

    @Column(name = "estado", length = 3)
    String estado;

    @Column(name = "nro_intentos_fallidos")
    Integer nroIntentosFallidos;

    @Column(name = "fecha_ultima_sesion")
    Date fechaUltimaSesion;

    @OneToMany(mappedBy = "pk.segUsuario")
    List<SegUsuarioAgencia> segUsuarioAgencias;
    
}
