package br.com.braz.rui.desafioinstagram.repositories;

import br.com.braz.rui.desafioinstagram.domain.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Integer> {
}
