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

import com.vacinas.restApi.Models.Vacinas;
import com.vacinas.restApi.Repository.VacinaRepository;

@RestController
@RequestMapping("api/vacina")
public class VacinasController {

	@Autowired
	private VacinaRepository repository;
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Vacinas salvar(@RequestBody @Valid Vacinas vacinas) {
		return repository.save(vacinas);
	}
	
	@GetMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public Vacinas get(@PathVariable Integer id) {
		return repository.findById(id)
				.orElseThrow(
						() -> 
						new ResponseStatusException(HttpStatus.BAD_REQUEST,"Vacina não existe"));
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Vacinas> listarVacinas() {		
		return repository.findAll();						
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Integer id) {
		
		repository.findById(id).map(vacinas ->{
			repository.delete(vacinas);
			return Void.TYPE;
		})
		.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
		
	}
	
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizar(@PathVariable Integer id, @RequestBody Vacinas vacinaAtualizada) {
		repository.findById(id).map(vacina ->{
			vacinaAtualizada.setId(vacinaAtualizada.getId());
			return repository.save(vacinaAtualizada);//O metodo save atualiza um registro se ele tiver um Id ou seja se ele já for cadastrado, por isso estou setando o ID.
		})
		.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
		
	}
	
	
	
	
}
