package pe.edu.cibertec.app_resiliencia_ciberfarma.service.impl;

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
    public Usuario obtenerPorId(Long id) {
        Usuario usuario = null;
        Optional<Usuario> optional = usuarioRepository.findById(id);
        if(optional.isPresent())
            usuario = optional.get();
        return usuario;
    }

    public Usuario fallbackObtenerUsuario(Long id, Throwable throwable) {
        System.out.println("Usuario no encontrado.");
        return new Usuario();
    }
}
