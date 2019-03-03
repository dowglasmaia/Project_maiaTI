package com.dowglasmaia.maiati.restcontroller;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dowglasmaia.maiati.domain.Funcionario;
import com.dowglasmaia.maiati.domain.dto.FuncionarioDTO;
import com.dowglasmaia.maiati.service.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioService service;

	/* Endpoint - Salvar */
	@PostMapping
	public ResponseEntity<Void> save(@Valid @RequestBody Funcionario funcionario) {
		Funcionario obj = service.salvar(funcionario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}

	/* Endpoint - Listar Todos */
	@GetMapping
	public ResponseEntity<List<FuncionarioDTO>> listarTodos() {
		List<Funcionario> lista = service.buscarTodos();
		List<FuncionarioDTO> listaDTO = lista.stream().map(obj -> new FuncionarioDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDTO);
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
}
