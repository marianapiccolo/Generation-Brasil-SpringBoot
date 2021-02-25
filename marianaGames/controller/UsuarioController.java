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
import com.games.marianaGames.model.Produto;
import com.games.marianaGames.model.Usuario;
import com.games.marianaGames.repository.UsuarioRepository;

@RestController 
@RequestMapping("/usuarios")
@CrossOrigin("*")

public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> GetAll(){
		return ResponseEntity.ok(usuarioRepository.findAll());
	}
	
	@GetMapping("/{id}") 
	public ResponseEntity<Usuario> GetById(@PathVariable long id){
		return usuarioRepository.findById(id)
				.map(resp ->ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
		
	@GetMapping("/usuario/{nome}")
	public ResponseEntity<List<Produto>> GetByNome(@PathVariable String nome) {
		return ResponseEntity.ok(usuarioRepository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<Usuario> postUsuario (@RequestBody Usuario usuario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuario));
	}
	
	@PutMapping
	public ResponseEntity<Usuario> putUsuario (@RequestBody Usuario usuario) {
		//return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(usuario));
		return ResponseEntity.ok(usuarioRepository.save(usuario));
	}
	
	@DeleteMapping("/{id}")
	public void deleteUsuario(@PathVariable long id) {
		usuarioRepository.deleteById(id);
	}
}
	