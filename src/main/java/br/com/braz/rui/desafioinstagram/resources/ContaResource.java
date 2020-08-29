package br.com.braz.rui.desafioinstagram.resources;

import br.com.braz.rui.desafioinstagram.domain.Conta;
import br.com.braz.rui.desafioinstagram.domain.Usuario;
import br.com.braz.rui.desafioinstagram.request.ContaRequest;
import br.com.braz.rui.desafioinstagram.services.ContaService;
import br.com.braz.rui.desafioinstagram.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/conta")
public class ContaResource {

    @Autowired
    ContaService contaService;

    @Autowired
    UsuarioService usuarioService;

    @RequestMapping(value = "/seguir/{idUsuario}", method = RequestMethod.PUT)
    public ResponseEntity<Void> seguir(@RequestBody Integer idConta, @PathVariable Integer idUsuario){
        Usuario usuario = usuarioService.buscar(idUsuario);
        Conta conta = contaService.buscar(idConta);
        contaService.seguir(conta, usuario);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
    public ResponseEntity<Void> criarConta(@RequestBody ContaRequest contaRequest){
        contaService.cadastrar(contaRequest.getSenha(), contaRequest.getNome(), contaRequest.getCelular(), contaRequest.getEmail());
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/desativar/{idDesativar}", method = RequestMethod.PUT)
    public ResponseEntity<Void> desativar(@PathVariable Integer idDesativar){
        contaService.desativar(idDesativar);
        return ResponseEntity.ok().build();
    }

}
