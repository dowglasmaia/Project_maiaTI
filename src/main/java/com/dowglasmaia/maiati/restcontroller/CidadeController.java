package com.dowglasmaia.maiati.restcontroller;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;

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

import com.dowglasmaia.maiati.domain.Cidade;
import com.dowglasmaia.maiati.domain.Estado;
import com.dowglasmaia.maiati.service.CidadeService;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

	@Autowired
	private CidadeService service;

	/* Endpoint - Listar Todos */
	@GetMapping
	public ResponseEntity<List<Cidade>> listarTodos() {
		List<Cidade> lista = service.buscarTodos();

		return ResponseEntity.ok().body(lista);
	}

	/* Endpoint - Buscar por ID */
	@GetMapping("/{id}")
	public ResponseEntity<Cidade> buscarPorID(@PathVariable Long id) {
		try {
			Cidade obj = service.buscarPorID(id);
			return ResponseEntity.ok().body(obj);
		} catch (Exception e) {
			throw new NoSuchElementException("Registro não encontrado");
		}

	}

	/* Endpoint - Buscar por nome */
	@GetMapping("lista/{nome}")
	public ResponseEntity<List<Cidade>> buscarPorNome(@PathVariable String nome) {
		try {
			List<Cidade> lista = service.buscarPorNome(nome);
			return ResponseEntity.ok().body(lista);
		} catch (Exception e) {
			throw new NoSuchElementException("Registro não encontrado");
		}

	}

	/* Endpoint - Salvar */
	@PostMapping
	public ResponseEntity<Void> save(@Valid @RequestBody Cidade cidade) {
		Cidade obj = service.salvar(cidade);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();

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
