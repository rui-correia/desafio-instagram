package br.com.braz.rui.desafioinstagram.resources;

import br.com.braz.rui.desafioinstagram.domain.Usuario;
import br.com.braz.rui.desafioinstagram.request.PostagemRequest;
import br.com.braz.rui.desafioinstagram.services.PostagemService;
import br.com.braz.rui.desafioinstagram.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioResource {

    @Autowired
    private UsuarioService usuarioService;


    //Busca um usuario por ID
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscar(@PathVariable Integer id){
        Usuario usuario = usuarioService.buscar(id);
        return ResponseEntity.ok().body(usuario);
    }

    //Busca usuarios pelo nome
    @RequestMapping(value = "/buscar/{nome}", method = RequestMethod.GET)
    public ResponseEntity<?> buscarUsuarios(@PathVariable String nome){
        List<Usuario> usuarios = usuarioService.buscarUsuarios(nome);
        return ResponseEntity.ok().body(usuarios);
    }


    //Mostra quem o usuario está seguindo
    @RequestMapping(value = "/seguindo/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscarSeguindo(@PathVariable Integer id){
        Usuario usuario = usuarioService.buscar(id);
        List<Usuario> seguindo = new ArrayList<>();
        seguindo = usuario.getConta().getSeguindo();
        return ResponseEntity.ok().body(seguindo);
    }

    //Exibe os seguidores de determinado usuário
    @RequestMapping(value = "/seguidores/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscarSeguidores(@PathVariable Integer id){
        Usuario usuario = usuarioService.buscar(id);
        List<Usuario> seguidores = new ArrayList<>();
        seguidores = usuario.getConta().getSeguidores();
        return ResponseEntity.ok().body(seguidores);
    }

}
