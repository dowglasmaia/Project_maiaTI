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

import com.dowglasmaia.maiati.domain.Departamento;
import com.dowglasmaia.maiati.service.DepartamentoService;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

	@Autowired
	private DepartamentoService service;

	/* Endpoint - Salvar */
	@PostMapping
	public ResponseEntity<Void> save(@Valid @RequestBody Departamento departamento) {
		Departamento obj = service.salvar(departamento);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}

	/* Endpoint - Listar Todos */
	@GetMapping
	public ResponseEntity<List<Departamento>> listarTodos() {
		List<Departamento> lista = service.buscarTodos();
		return ResponseEntity.ok().body(lista);
	}

	/* Endpoint - Buscar por ID */
	@GetMapping("/{id}")
	public ResponseEntity<Departamento> buscarPorID(@PathVariable Long id) {
		try {
			Departamento obj = service.buscarPorID(id);
			return ResponseEntity.ok().body(obj);
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
