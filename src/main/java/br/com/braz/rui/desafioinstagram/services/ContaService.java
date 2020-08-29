package br.com.braz.rui.desafioinstagram.services;

import br.com.braz.rui.desafioinstagram.domain.Conta;
import br.com.braz.rui.desafioinstagram.domain.Usuario;
import br.com.braz.rui.desafioinstagram.repositories.ContaRepository;
import br.com.braz.rui.desafioinstagram.repositories.UsuarioRepository;
import br.com.braz.rui.desafioinstagram.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContaService {

    @Autowired
    ContaRepository contaRepository;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    UsuarioRepository usuarioRepository;

    public Conta seguir(Conta conta, Usuario usuario) {
        conta.getSeguindo().add(usuario);
        usuario.getConta().getSeguidores().add(conta.getUsuario());
        usuarioRepository.save(usuario);
        return contaRepository.save(conta);
    }

    //Buscar conta por id
    public Conta buscar(Integer id){
        Optional<Conta> conta = contaRepository.findById(id);
        return conta.orElseThrow(() -> new ObjectNotFoundException("Conta não encontrada! Id: " + id + "Tipo: " + Conta.class.getName()));
    }

    //Cadastra uma nova conta (e usuário)
    public Conta cadastrar(String senha, String nome, String celular, String email){
        Conta conta = new Conta();

        Usuario usuario = usuarioService.cadastrar(nome, celular, email);
        conta.setSenha(senha);
        conta.setUsuario(usuario);
        conta.setAtivo(true);
        contaRepository.save(conta);
        return conta;
    }

    //Desativa uma conta
    public void desativar(Integer idDesativar){
        Conta conta = buscar(idDesativar);
        conta.setAtivo(false);
        contaRepository.save(conta);
    }

}
