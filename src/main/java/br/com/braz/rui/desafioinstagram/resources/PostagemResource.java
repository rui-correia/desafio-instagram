package br.com.braz.rui.desafioinstagram.resources;

import br.com.braz.rui.desafioinstagram.domain.Comentario;
import br.com.braz.rui.desafioinstagram.request.ComentarioRequest;
import br.com.braz.rui.desafioinstagram.request.PostagemRequest;
import br.com.braz.rui.desafioinstagram.services.ComentarioService;
import br.com.braz.rui.desafioinstagram.services.PostagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/postagem")
public class PostagemResource {

    @Autowired
    ComentarioService comentarioService;

    @Autowired
    private PostagemService postagemService;

    //Cria um novo post
    @RequestMapping(value = "/postar", method = RequestMethod.POST)
    public ResponseEntity<?> postar(@RequestBody PostagemRequest postagemRequest){
        postagemService.postar(postagemRequest.getIdUsuarioLogado(), postagemRequest.getTexto(), postagemRequest.getImagem());
        return ResponseEntity.ok().build();
    }

    //Comenta um post existente
    @RequestMapping(value = "/comentar", method = RequestMethod.POST)
    public ResponseEntity<?> comentar(@RequestBody ComentarioRequest comentarioRequest){
        comentarioService.comentar(comentarioRequest);
        return ResponseEntity.ok().build();
    }

    //Exclui uma postagem
    @RequestMapping(value = "/excluir", method = RequestMethod.DELETE)
    public ResponseEntity<Void> excluirPost(@RequestBody Integer idPostagem, @RequestBody Integer idUsuarioLogado){
        postagemService.excluirPostagem(idPostagem,idUsuarioLogado);
        return ResponseEntity.ok().build();
    }


}
