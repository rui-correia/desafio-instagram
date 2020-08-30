package br.com.braz.rui.desafioinstagram.services;

import br.com.braz.rui.desafioinstagram.domain.Conta;
import br.com.braz.rui.desafioinstagram.domain.Postagem;
import br.com.braz.rui.desafioinstagram.domain.Usuario;
import br.com.braz.rui.desafioinstagram.repositories.PostagemRepository;
import br.com.braz.rui.desafioinstagram.repositories.UsuarioRepository;
import br.com.braz.rui.desafioinstagram.services.exceptions.NullValueException;
import br.com.braz.rui.desafioinstagram.services.exceptions.ObjectNotFoundException;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.support.NullValue;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class PostagemService {

    @Autowired
    private PostagemRepository postagemRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    //Realiza uma nova postagem
    public Postagem postar(Integer idUsuarioLogado, String texto, String imagem){
        Postagem postagem = new Postagem();
        Usuario usuario = usuarioService.buscar(idUsuarioLogado);
        postagem.setUsuario(usuario);
        postagem.setData(LocalDateTime.now());
        postagem.setTexto(texto);
        postagem.setImagem("imagem.jpg");
        postagem.setCurtidas(0);
        usuario.getPostagens().add(postagem);

        postagemRepository.save(postagem);
        usuarioRepository.save(usuario);
        return postagem;
    }

    //Busca uma postagem por id
    public Postagem buscar(Integer id){
        Optional<Postagem> postagem = postagemRepository.findById(id);
        if (postagem != null){
            return postagem.get();
        }
        throw new ObjectNotFoundException("Posgatem não encontrada! Id: " + id + " Tipo: " + Postagem.class.getName());
    }

    //Exclui uma postagem
    public void excluirPostagem(Integer idPostagem, Integer idUsuarioLogado) {
        if (idPostagem == null && idUsuarioLogado == null){
            throw new NullValueException("Favor preencher os dois campos obrigatorios");
        }
        Usuario usuario = usuarioService.buscar(idUsuarioLogado);
        Postagem postagem = buscar(idPostagem);

        List<Postagem> postagens = listaPostagens(usuario.getId());

        for (Postagem p : postagens) {
            if (p.getId() == postagem.getId()){
                postagemRepository.deleteById(postagem.getId());
            }
        }
    }

    //Lista postagens de um usuario
    public List<Postagem> listaPostagens(Integer idUsuario){
        List<Postagem> postagens = new ArrayList<>();
        boolean exiteUsuario = usuarioService.verificarUsuario(idUsuario);

        if (!exiteUsuario){
            Usuario usuario = usuarioService.buscar(idUsuario);
            postagens = usuario.getPostagens();
        }
        return postagens;
    }

}
