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

    @Autowired
    private PostagemService postagemService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscar(@PathVariable Integer id){
        Usuario usuario = usuarioService.buscar(id);
        return ResponseEntity.ok().body(usuario);
    }

    @RequestMapping(value = "/seguindo/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscarSeguindo(@PathVariable Integer id){
        Usuario usuario = usuarioService.buscar(id);
        List<Usuario> seguindo = new ArrayList<>();
        seguindo = usuario.getConta().getSeguindo();
        return ResponseEntity.ok().body(seguindo);
    }

    @RequestMapping(value = "/seguidores/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscarSeguidores(@PathVariable Integer id){
        Usuario usuario = usuarioService.buscar(id);
        List<Usuario> seguidores = new ArrayList<>();
        seguidores = usuario.getConta().getSeguidores();
        return ResponseEntity.ok().body(seguidores);
    }

    @RequestMapping(value = "/postar", method = RequestMethod.POST)
    public ResponseEntity<?> postar(@RequestBody PostagemRequest postagemRequest){
        postagemService.postar(postagemRequest.getIdUsuarioLogado(), postagemRequest.getTexto(), postagemRequest.getImagem());
        return ResponseEntity.ok().build();
    }




}
