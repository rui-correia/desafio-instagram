package br.com.braz.rui.desafioinstagram;

import br.com.braz.rui.desafioinstagram.domain.Conta;
import br.com.braz.rui.desafioinstagram.domain.Usuario;
import br.com.braz.rui.desafioinstagram.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class DesafioInstagramApplication implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private PostagemRepository postagemRepository;
	@Autowired
	private MensagemRepository mensagemRepository;
	@Autowired
	private ComentarioRepository comentarioRepository;
	@Autowired
	private ContaRepository contaRepository;

	public static void main(String[] args) {
		SpringApplication.run(DesafioInstagramApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception{

		Usuario usuario1 =  new Usuario();
		usuario1.setNome("Usuario1");
		usuario1.setEmail("usuario1@gmail.com");
		usuario1.setCelular("+5583988872321");

		Usuario usuario2 =  new Usuario();
		usuario2.setNome("Usuario2");
		usuario2.setEmail("usuario2@gmail.com");
		usuario2.setCelular("+5583988872322");

		Usuario usuario3 =  new Usuario();
		usuario3.setNome("Usuario3");
		usuario3.setEmail("usuario3@gmail.com");
		usuario3.setCelular("+5583988872323");

		Usuario usuario4 =  new Usuario();
		usuario4.setNome("Usuario4");
		usuario4.setEmail("usuario4@gmail.com");
		usuario4.setCelular("+5583988872324");

		Usuario usuario5 =  new Usuario();
		usuario5.setNome("Usuario5");
		usuario5.setEmail("usuario5@gmail.com");
		usuario5.setCelular("+5583988872325");

		Conta conta1 = new Conta();
		conta1.setUsuario(usuario1);
		conta1.setAtivo(true);
		conta1.setSenha("123456");
		usuario1.setConta(conta1);

		Conta conta2 = new Conta();
		conta2.setUsuario(usuario2);
		conta2.setAtivo(true);
		conta2.setSenha("123456");
		usuario2.setConta(conta2);

		Conta conta3 = new Conta();
		conta3.setUsuario(usuario3);
		conta3.setAtivo(true);
		conta3.setSenha("123456");
		usuario3.setConta(conta3);

		Conta conta4 = new Conta();
		conta4.setUsuario(usuario4);
		conta4.setAtivo(true);
		conta4.setSenha("123456");
		usuario4.setConta(conta4);

		Conta conta5 = new Conta();
		conta5.setUsuario(usuario5);
		conta5.setAtivo(true);
		conta5.setSenha("123456");
		usuario5.setConta(conta5);

		usuario1.getConta().getSeguindo().add(usuario2);
		usuario2.getConta().getSeguidores().add(usuario1);

		usuario2.getConta().getSeguindo().addAll(Arrays.asList(usuario3, usuario4));
		usuario3.getConta().getSeguidores().add(usuario2);
		usuario4.getConta().getSeguidores().add(usuario2);

		usuario3.getConta().getSeguindo().add(usuario1);
		usuario1.getConta().getSeguidores().add(usuario3);



		//contaRepository.saveAll(Arrays.asList(conta1, conta2, conta3, conta4, conta5));
		usuarioRepository.saveAll(Arrays.asList(usuario1, usuario2, usuario3, usuario4, usuario5));

	}


}
