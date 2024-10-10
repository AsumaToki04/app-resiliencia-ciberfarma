package pe.edu.cibertec.app_resiliencia_ciberfarma.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.app_resiliencia_ciberfarma.service.IUsuarioService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuario")
public class UsuarioController {

    private final IUsuarioService iUsuarioService;

    @GetMapping("/{id}")
    public String obtenerUsuarioPorId(@PathVariable("id") Long id) {
        return iUsuarioService.obtenerPorId(id);
    }
}
