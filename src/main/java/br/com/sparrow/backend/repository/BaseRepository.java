package br.com.sparrow.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sparrow.backend.model.Base;

public interface BaseRepository extends JpaRepository<Base, Integer>{

}
