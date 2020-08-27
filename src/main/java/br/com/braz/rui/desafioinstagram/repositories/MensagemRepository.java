package br.com.braz.rui.desafioinstagram.repositories;

import br.com.braz.rui.desafioinstagram.domain.Mensagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensagemRepository extends JpaRepository<Mensagem, Integer> {
}
