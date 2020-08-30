package br.com.braz.rui.desafioinstagram.repositories;

import br.com.braz.rui.desafioinstagram.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    public Usuario findByEmail(String email);
    public List<Usuario> findByName(String nome);
}
