package com.vacinas.restApi.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.vacinas.restApi.Models.Usuario;
import com.vacinas.restApi.Repository.UsuariosRepository;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {

	@Autowired
	private UsuariosRepository repository;
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario salvar(@RequestBody @Valid Usuario usuario) {
		return repository.save(usuario);
	}
	
	@GetMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public Usuario get(@PathVariable Integer id) {
		return repository.findById(id)
				.orElseThrow(
						() -> 
						new ResponseStatusException(HttpStatus.BAD_REQUEST,"Cliente não existe"));
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Usuario> listarUsuarios() {		
		return repository.findAll();						
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Integer id) {
		
		repository.findById(id).map(usuario ->{
			repository.delete(usuario);
			return Void.TYPE;
		})
		.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		
	}
	
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizar(@PathVariable Integer id, @RequestBody Usuario usuarioAtualizado) {
		repository.findById(id).map(usuario ->{
			usuarioAtualizado.setId(usuarioAtualizado.getId());
			return repository.save(usuarioAtualizado);//O metodo save atualiza um registro se ele tiver um Id ou seja se ele já for cadastrado, por isso estou setando o ID.
		})
		.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
		
	}
	
}
