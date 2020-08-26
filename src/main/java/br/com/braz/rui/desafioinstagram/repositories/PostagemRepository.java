package br.com.braz.rui.desafioinstagram.repositories;

import br.com.braz.rui.desafioinstagram.domain.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostagemRepository extends JpaRepository<Postagem, Integer> {
}
