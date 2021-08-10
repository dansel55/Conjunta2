package ec.edu.espe.examen2.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "GEN_AGENCIA")
public class GenAgencia implements Serializable {
    @EmbeddedId
    private GenAgenciaPk pk;
    
    @Column(name = "nombre", length = 150)
    String nombre;

    @OneToMany(mappedBy = "pk.genAgencia")
    List<SegUsuarioAgencia> segUsuarioAgencias;
}
