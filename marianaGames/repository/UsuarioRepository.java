package com.games.marianaGames.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.games.marianaGames.model.Produto;
import com.games.marianaGames.model.Usuario;

@Repository 
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public List<Produto> findAllByNomeContainingIgnoreCase(String nome);

	
 }
