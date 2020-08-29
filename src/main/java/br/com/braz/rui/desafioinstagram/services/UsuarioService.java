package br.com.braz.rui.desafioinstagram.services;

import br.com.braz.rui.desafioinstagram.domain.Usuario;
import br.com.braz.rui.desafioinstagram.repositories.UsuarioRepository;
import br.com.braz.rui.desafioinstagram.services.exceptions.ObjectDuplicatedException;
import br.com.braz.rui.desafioinstagram.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    //Buscar usuario por id
    public Usuario buscar(Integer id){
        Optional <Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional != null){
            Usuario usuario = usuarioOptional.get();
            if (!usuario.getConta().isAtivo()){
                throw new ObjectNotFoundException("Usuário não encontrado! Id: " + id + " Tipo: " + Usuario.class.getName());
            }
        }
        return usuarioOptional.get();
    }

    //Cadastra um novo usuario
    public Usuario cadastrar(String nome, String celular, String email){
        Usuario usuario = new Usuario(nome, celular, email);
        if (usuarioRepository.findByEmail(email) != null){
            throw  new ObjectDuplicatedException("Este email já está em uso." + Usuario.class.getName());
        }
        usuarioRepository.save(usuario);
        return usuario;
    }



}
