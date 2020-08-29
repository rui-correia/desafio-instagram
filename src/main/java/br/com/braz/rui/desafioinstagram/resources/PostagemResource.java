package br.com.braz.rui.desafioinstagram.resources;

import br.com.braz.rui.desafioinstagram.domain.Comentario;
import br.com.braz.rui.desafioinstagram.request.ComentarioRequest;
import br.com.braz.rui.desafioinstagram.services.ComentarioService;
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

    @RequestMapping(value = "/comentar", method = RequestMethod.POST)
    public ResponseEntity<?> comentar(@RequestBody ComentarioRequest comentarioRequest){
        comentarioService.comentar(comentarioRequest);
        return ResponseEntity.ok().build();
    }
}
