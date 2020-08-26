package br.com.braz.rui.desafioinstagram.repositories;

import br.com.braz.rui.desafioinstagram.domain.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {
}
