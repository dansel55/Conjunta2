package ec.edu.espe.examen2.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
@Table(name = "SEG_USUARIO_AGENCIA")
public class SegUsuarioAgencia implements Serializable {
    
    @EmbeddedId
    private SegUsuarioAgenciaPk pk;
    
    @Column(name = "por_omision", length = 1)
    String porOmision;
}
