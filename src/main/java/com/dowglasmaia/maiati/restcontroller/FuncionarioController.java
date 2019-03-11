package com.dowglasmaia.maiati.restcontroller;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dowglasmaia.maiati.domain.Funcionario;
import com.dowglasmaia.maiati.domain.func.dto.FuncionarioDTO;
import com.dowglasmaia.maiati.domain.func.dto.FuncionarioNewDTO;
import com.dowglasmaia.maiati.service.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioService service;

	/* Endpoint - Salvar */
	@PostMapping
	public ResponseEntity<Void> save(@Valid @RequestBody FuncionarioNewDTO objDTO) {
		Funcionario obj = service.fromDTO(objDTO);
		service.salvar(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}

	/* Endpoint - Listar Todos */
	@GetMapping
	public List<FuncionarioDTO> listarTodos() {
		List<Funcionario> lista = service.buscarTodos();
		List<FuncionarioDTO> listaDTO = lista.stream().map(obj -> new FuncionarioDTO(obj)).collect(Collectors.toList());
		return listaDTO;
	}

	/* Endpoint - Buscar por ID */
	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> buscarPorID(@PathVariable Long id) {
		try {
			Funcionario obj = service.buscarPorID(id);
			return ResponseEntity.ok().body(obj);
		} catch (Exception e) {
			throw new NoSuchElementException("Registro não encontrado");
		}

	}

	/* Endpoint - Buscar por nome */
	@GetMapping("lista/{nome}")
	public ResponseEntity<List<Funcionario>> buscarPorNome(@PathVariable String nome) {
		try {
			List<Funcionario> lista = service.buscarPorNome(nome);
			return ResponseEntity.ok().body(lista);
		} catch (Exception e) {
			throw new NoSuchElementException("Registro não encontrado");
		}

	}

	/* Endpoint - Delete */
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		try {
			service.remove(id);
		} catch (Exception e) {
			throw new NoSuchElementException("O Operação Não realizada!");
		}
	}

	/* Endpoint - Update */
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> update(@Valid @RequestBody Funcionario obj, @PathVariable Long id) {
		obj.setId(id);
		try {
			obj = service.update(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.noContent().build();
	}

}
