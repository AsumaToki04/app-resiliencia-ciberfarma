package pe.edu.cibertec.app_resiliencia_ciberfarma.service.impl;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.app_resiliencia_ciberfarma.model.Usuario;
import pe.edu.cibertec.app_resiliencia_ciberfarma.repository.UsuarioRepository;
import pe.edu.cibertec.app_resiliencia_ciberfarma.service.IUsuarioService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService implements IUsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Override
    @CircuitBreaker(name = "ciberfarma", fallbackMethod = "fallbackUsuarioNoEncontrado")
    public String obtenerPorId(Long id) {
        Optional<Usuario> optional = usuarioRepository.findById(id);
        if(optional.isPresent())
            return optional.get().toString();
        else
            throw new RuntimeException("Usuario no encontrado.");
    }

    public String fallbackUsuarioNoEncontrado(Long id, Throwable throwable) {
        return "Usuario con ID " + id + " no encontrado";
    }
}
