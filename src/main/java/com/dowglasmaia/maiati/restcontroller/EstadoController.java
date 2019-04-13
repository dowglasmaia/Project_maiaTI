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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dowglasmaia.maiati.domain.Cidade;
import com.dowglasmaia.maiati.domain.Estado;
import com.dowglasmaia.maiati.service.CidadeService;
import com.dowglasmaia.maiati.service.EstadoService;

@RestController
@RequestMapping("/estados")
public class EstadoController {

	@Autowired
	private EstadoService service;

	@Autowired
	private CidadeService cidService;

	/* Endpoint - Listar Todos */
	@GetMapping
	public ResponseEntity<List<Estado>> listarTodos() {
		List<Estado> lista = service.buscarTodos();
		return ResponseEntity.ok().body(lista);
	}

	/* Endpoint - Buscar por ID */
	@GetMapping("/{id}")
	public ResponseEntity<Estado> buscarPorID(@PathVariable Long id) {
		try {
			Estado obj = service.buscarPorID(id);
			return ResponseEntity.ok().body(obj);
		} catch (Exception e) {
			throw new NoSuchElementException("Registro não encontrado");
		}

	}

	/* Endpoint - Salvar */
	@PostMapping
	public ResponseEntity<Void> save(@Valid @RequestBody Estado uf) {
		Estado obj = service.salvar(uf);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}

	/* Endpoint - Buscar por nome */
	@GetMapping("lista/{nome}")
	public ResponseEntity<List<Estado>> buscarPorNome(@PathVariable String nome) {
		try {
			List<Estado> lista = service.buscarPorNome(nome);
			return ResponseEntity.ok().body(lista);
		} catch (Exception e) {
			throw new NoSuchElementException("Registro não encontrado");
		}

	}

	/* Endpoint - Cidades com Base no ID do seu Estado */
	@RequestMapping(value = "/{estadoId}/cidades", method = RequestMethod.GET)
	public ResponseEntity<List<Cidade>> findCidades(@PathVariable Long estadoId) {
		List<Cidade> list;
		try {
			list = cidService.buscarPorNome(estadoId);
			return ResponseEntity.ok().body(list);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
