package br.com.braz.rui.desafioinstagram.services;

import br.com.braz.rui.desafioinstagram.domain.Comentario;
import br.com.braz.rui.desafioinstagram.domain.Postagem;
import br.com.braz.rui.desafioinstagram.domain.Usuario;
import br.com.braz.rui.desafioinstagram.repositories.ComentarioRepository;
import br.com.braz.rui.desafioinstagram.repositories.PostagemRepository;
import br.com.braz.rui.desafioinstagram.repositories.UsuarioRepository;
import br.com.braz.rui.desafioinstagram.request.ComentarioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ComentarioService {

    @Autowired
    ComentarioRepository comentarioRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PostagemRepository postagemRepository;

    public Comentario comentar(ComentarioRequest comentarioRequest){
        Comentario comentario = new Comentario();
        Usuario usuario = usuarioRepository.findById(comentarioRequest.getIdUsuarioLogado()).get();
        Postagem postagem = postagemRepository.findById(comentarioRequest.getIdPostagem()).get();
        comentario.setUsuario(usuario);
        comentario.setData(LocalDateTime.now());
        comentario.setPostagem(postagem);
        usuario.getComentarios().add(comentario);
        postagem.getComentarios().add(comentario);

        postagemRepository.save(postagem);
        usuarioRepository.save(usuario);
        comentarioRepository.save(comentario);

        return comentario;
    }
}
