package com.generation.blogPessoal.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.blogPessoal.Service.UsuarioService;

import com.generation.blogPessoal.model.Usuario;
import com.generation.blogPessoal.model.UsuarioLogin;
import com.generation.blogPessoal.repository.UsuarioRepository;



@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	

	@Autowired
	private UsuarioRepository repository;

	
	@PostMapping("/logar")
	public  ResponseEntity<UsuarioLogin> Autentication(@RequestBody Optional<UsuarioLogin>user) {
		return usuarioService.Logar(user)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Object> postCadastrar(@Valid @RequestBody Usuario usuario) {
		Optional<Usuario> usuarioCriado = usuarioService.CadastrarUsuario(usuario);
		if (usuarioCriado.isEmpty()) {
			return ResponseEntity.status(200).body("Usuario ja existente!");
		} else {
			return ResponseEntity.status(201).body(usuarioCriado.get());

		}
				
	}
	
	@GetMapping("/todos")
	public List<Usuario> findAll() {
		return repository.findAll();
	}
	
}
