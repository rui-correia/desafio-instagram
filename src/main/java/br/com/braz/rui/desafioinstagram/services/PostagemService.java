package br.com.braz.rui.desafioinstagram.services;

import br.com.braz.rui.desafioinstagram.domain.Conta;
import br.com.braz.rui.desafioinstagram.domain.Postagem;
import br.com.braz.rui.desafioinstagram.domain.Usuario;
import br.com.braz.rui.desafioinstagram.repositories.PostagemRepository;
import br.com.braz.rui.desafioinstagram.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PostagemService {

    @Autowired
    private PostagemRepository postagemRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    public Postagem postar(Integer idUsuarioLogado, String texto, String imagem){
        Postagem postagem = new Postagem();
        Usuario usuario = usuarioService.buscar(idUsuarioLogado);
        postagem.setUsuario(usuario);
        postagem.setData(LocalDateTime.now());
        postagem.setTexto(texto);
        postagem.setImagem("imagem.jpg");
        usuario.getPostagens().add(postagem);

        postagemRepository.save(postagem);
        usuarioRepository.save(usuario);
        return postagem;
    }



}
