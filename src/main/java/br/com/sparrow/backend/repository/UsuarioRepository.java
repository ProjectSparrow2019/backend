package br.com.sparrow.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sparrow.backend.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	Usuario findByLoginAndSenha(String login, String senha);
}
