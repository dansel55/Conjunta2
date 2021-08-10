/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.examen2.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
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
public class GenAgenciaPk implements Serializable{
    
    @Column(name = "cod_agencia", nullable = false)
    private String codAgencia;

    @Column(name = "cod_empresa", nullable = false)
    private String codEmpresa;
}
