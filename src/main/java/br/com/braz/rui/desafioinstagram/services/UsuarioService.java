package br.com.braz.rui.desafioinstagram.services;

import br.com.braz.rui.desafioinstagram.domain.Usuario;
import br.com.braz.rui.desafioinstagram.repositories.UsuarioRepository;
import br.com.braz.rui.desafioinstagram.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    //Buscar usuario por id
    public Usuario buscar(Integer id){
        Optional <Usuario> usuario = repository.findById(id);
        return usuario.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado! Id: " + id + "Tipo: " + Usuario.class.getName()));
    }

}
