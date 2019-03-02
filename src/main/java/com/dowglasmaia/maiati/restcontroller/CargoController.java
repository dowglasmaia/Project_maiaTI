package com.dowglasmaia.maiati.restcontroller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
		List<CargoDTO>listaDTO = lista.stream().map(obj -> new CargoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDTO);
	}

	
}
