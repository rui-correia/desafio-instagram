package br.com.braz.rui.desafioinstagram;

import br.com.braz.rui.desafioinstagram.domain.Usuario;
import br.com.braz.rui.desafioinstagram.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
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
	private ConfiguracaoRepository configuracaoRepository;

	public static void main(String[] args) {
		SpringApplication.run(DesafioInstagramApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception{

		Usuario usuario1 =  new Usuario();
		usuario1.setNome("Usuario1");
		usuario1.setEmail("usuario1@gmail.com");
		usuario1.setNumero("+5583988872321");

		Usuario usuario2 =  new Usuario();
		usuario2.setNome("Usuario2");
		usuario2.setEmail("usuario2@gmail.com");
		usuario2.setNumero("+5583988872322");

		Usuario usuario3 =  new Usuario();
		usuario3.setNome("Usuario3");
		usuario3.setEmail("usuario3@gmail.com");
		usuario3.setNumero("+5583988872323");

		Usuario usuario4 =  new Usuario();
		usuario4.setNome("Usuario4");
		usuario4.setEmail("usuario4@gmail.com");
		usuario4.setNumero("+5583988872324");

		Usuario usuario5 =  new Usuario();
		usuario5.setNome("Usuario5");
		usuario5.setEmail("usuario5@gmail.com");
		usuario5.setNumero("+5583988872325");

		usuario1.getAmigos().add(usuario2);
		usuario2.getAmigos().addAll(Arrays.asList(usuario3, usuario4));
		usuario3.getAmigos().add(usuario1);

		usuarioRepository.saveAll(Arrays.asList(usuario1,usuario2,usuario3,usuario4,usuario5));



	}


}
