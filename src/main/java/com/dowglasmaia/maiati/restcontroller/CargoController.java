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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dowglasmaia.maiati.domain.Cargo;
import com.dowglasmaia.maiati.domain.dto.CargoDTO;
import com.dowglasmaia.maiati.service.CargoService;

@RestController
@RequestMapping("/cargos")
public class CargoController {

	@Autowired
	private CargoService service;

	/* Endpoint - Listar Todos */
	@GetMapping
	public ResponseEntity<List<CargoDTO>> listarTodos() {
		List<Cargo> lista = service.buscarTodos();
		List<CargoDTO> listaDTO = lista.stream().map(obj -> new CargoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDTO);
	}

	/* Endpoint - Buscar por ID */
	@GetMapping("/{id}")
	public ResponseEntity<Cargo> buscarPorID(@PathVariable Long id) {
		try {
			Cargo obj = service.buscarPorID(id);
			return ResponseEntity.ok().body(obj);
		} catch (Exception e) {
			throw new NoSuchElementException("Registro não encontrado");
		}

	}

	/* Endpoint - Salvar */
	@PostMapping
	public ResponseEntity<Void> save(@Valid @RequestBody Cargo cargo) {
		Cargo obj = service.salvar(cargo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}

	/* Endpoint - Update */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> update(@Valid @RequestBody CargoDTO objDTO, @PathVariable Long id) {
		Cargo obj = service.fromDTO(objDTO);
		obj.setId(id);
		try {			
			obj = service.update(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.noContent().build();
	}

	/* Endpoint - Buscar por nome */
	@GetMapping("lista/{nome}")
	public ResponseEntity<List<Cargo>> buscarPorNome(@PathVariable String nome) {
		try {
			List<Cargo> lista = service.buscarPorNome(nome);
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
