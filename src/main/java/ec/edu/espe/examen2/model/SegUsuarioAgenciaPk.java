/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.examen2.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Usuario
 */
@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SegUsuarioAgenciaPk implements Serializable{
    
    @ManyToOne(fetch = FetchType.EAGER)
    SegUsuario segUsuario;    
  
    @ManyToOne(fetch = FetchType.EAGER)
    GenAgencia genAgencia;
}
