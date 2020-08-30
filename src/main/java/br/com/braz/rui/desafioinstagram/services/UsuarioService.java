package br.com.braz.rui.desafioinstagram.services;

import br.com.braz.rui.desafioinstagram.domain.Usuario;
import br.com.braz.rui.desafioinstagram.repositories.UsuarioRepository;
import br.com.braz.rui.desafioinstagram.services.exceptions.NullValueException;
import br.com.braz.rui.desafioinstagram.services.exceptions.ObjectDuplicatedException;
import br.com.braz.rui.desafioinstagram.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
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

    //Verifica se exite um usuário ativo com o id informado
    public boolean verificarUsuario(Integer id){
       boolean existeUsuario = usuarioRepository.existsById(id);
       if (existeUsuario){
           Usuario usuario = buscar(id);
           if (!usuario.getConta().isAtivo()){
               return false;
           }
       }
       return existeUsuario;
    }

    //Validando campo apenas numeros
    public boolean apenasNumeros(String verificar){
        if (!verificar.matches("^[0-9]*$")){
            return false;
        }
        return true;
    }

    //Cadastra um novo usuario
    public Usuario cadastrar(String nome, String celular, String email){
        if (!apenasNumeros(celular)){
            throw new NullValueException("Favor inserir apenas numeros no celular.");
        }
        Usuario usuario = new Usuario(nome, celular, email);
        if (usuarioRepository.findByEmail(email) != null){
            throw  new ObjectDuplicatedException("Este email já está em uso." + Usuario.class.getName());
        }
        usuarioRepository.save(usuario);
        return usuario;
    }

    //Busca uma lista de usuarios com determinado nome
    public List<Usuario> buscarUsuarios(String nome) {
    List<Usuario> usuarios;
    return usuarios = usuarioRepository.findByName(nome);
    }
}
