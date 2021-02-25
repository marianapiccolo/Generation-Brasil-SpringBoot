package com.games.marianaGames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.games.marianaGames.model.Categoria;

@Repository 

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	public List<Categoria> findAllByNomeContainingIgnoreCase (String nome);

	public List<Categoria> findAll();

	
	}

	

