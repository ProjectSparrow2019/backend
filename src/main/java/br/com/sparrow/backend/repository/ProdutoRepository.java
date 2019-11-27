package br.com.sparrow.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sparrow.backend.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
