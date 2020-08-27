package br.com.braz.rui.desafioinstagram.resources;

import br.com.braz.rui.desafioinstagram.domain.Usuario;
import br.com.braz.rui.desafioinstagram.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

    @Autowired
    private UsuarioService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscar(@PathVariable Integer id){
        Usuario usuario = service.buscar(id);
        return ResponseEntity.ok().body(usuario);
    }

    @RequestMapping(value = "/amigos/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscarAmigos(@PathVariable Integer id){
        Usuario usuario = service.buscar(id);
        List<Usuario> amigos = new ArrayList<>();
        amigos = usuario.getAmigos();
        return ResponseEntity.ok().body(amigos);
    }

}
