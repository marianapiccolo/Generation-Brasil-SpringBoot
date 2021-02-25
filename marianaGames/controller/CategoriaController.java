package com.games.marianaGames.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.games.marianaGames.model.Categoria;
import com.games.marianaGames.repository.CategoriaRepository;

@RestController 
@RequestMapping("/categoria")
@CrossOrigin("*")

public class CategoriaController {
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> GetAll(){
		return ResponseEntity.ok(categoriaRepository.findAll());
	}
	
	@GetMapping("/{id}") 
	public ResponseEntity<Categoria> GetById(@PathVariable long id){
		return categoriaRepository.findById(id)
				.map(resp ->ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
		
	}
	
	@GetMapping("/categoria/{nome}")
	public ResponseEntity<List<Categoria>> GetByNome(@PathVariable String nome){
		return ResponseEntity.ok(categoriaRepository.findAllByNomeContainingIgnoreCase(nome));
	}

	@PostMapping
	public ResponseEntity<Categoria> postCategoria (@RequestBody Categoria categoria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(categoria));
	}
	
	@PutMapping
	public ResponseEntity<Categoria> putCategoria (@RequestBody Categoria categoria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(categoria));
			}
	
	@DeleteMapping ("/{id}")
	public void deleteCategoria (@PathVariable long id) {
		categoriaRepository.deleteById(id);
	}	
}