package ec.edu.espe.examen2.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.espe.examen2.dao.GenAgenciaRepository;
import ec.edu.espe.examen2.dao.SegUsuarioRepository;
import ec.edu.espe.examen2.dto.RegistrarUsuarioDto;
import ec.edu.espe.examen2.model.GenAgencia;
import ec.edu.espe.examen2.model.SegUsuario;
import ec.edu.espe.examen2.model.SegUsuarioAgencia;
import ec.edu.espe.examen2.model.SegUsuarioAgenciaPk;

@Service
public class SegUsuarioService {
    @Autowired
    private SegUsuarioRepository segUsuarioRepository;

    @Autowired
    private GenAgenciaRepository genAgenciaRepository;

    @Transactional
    public SegUsuario crearUsuario(RegistrarUsuarioDto registrarUsuarioDto) {
        Optional<SegUsuario> usuarioOptional = this.segUsuarioRepository.findByIdentificacion(registrarUsuarioDto.getIdentificacion());
        if(usuarioOptional.isPresent()) {
            throw new EntityNotFoundException("Usuario ya registrado");
        }
        usuarioOptional = this.segUsuarioRepository.findById(registrarUsuarioDto.getCodUsuario());
        if(usuarioOptional.isPresent()) {
            throw new EntityNotFoundException("Codigo de usuario ya registrado");
        }
        SegUsuario usuario = SegUsuario.builder()
            .codUsuario(registrarUsuarioDto.getCodUsuario())
            .email(registrarUsuarioDto.getEmail())
            .estado("ACT")
            .fechaUltimaSesion(new Date())
            .identificacion(registrarUsuarioDto.getIdentificacion())
            .nombre(registrarUsuarioDto.getNombre())
            .nroIntentosFallidos(0).build();
        this.segUsuarioRepository.save(usuario);
        List<SegUsuarioAgencia> segUsuarioAgencias = usuario.getSegUsuarioAgencias();
        for(String agencia : registrarUsuarioDto.getAgencias()) {
            Optional<GenAgencia> agenciaOptional = this.genAgenciaRepository.findByPkCodAgencia(agencia);
            if(agenciaOptional.isPresent()) {
                segUsuarioAgencias.add(SegUsuarioAgencia.builder()
                    //.genAgencia(agenciaOptional.get())
                    .porOmision("1")
                        .pk(SegUsuarioAgenciaPk.builder().genAgencia(agenciaOptional.get()).segUsuario(usuario).build())
                    //.segUsuario(usuario)
                    .build());
            }
        }
        this.segUsuarioRepository.save(usuario);
        return usuario;
    }
}
