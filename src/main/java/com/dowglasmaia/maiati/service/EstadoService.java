package com.dowglasmaia.maiati.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dowglasmaia.maiati.domain.Estado;
import com.dowglasmaia.maiati.repository.domain.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository repository;

	/* Salvar */
	public Estado salvar(Estado obj) {
		return repository.save(obj);
	}

	/* Buscar por ID */
	public Estado buscarPorID(Long id) throws Exception {
		Estado uf = repository.findById(id);
		if (uf != null) {
			return uf;
		} else {
			throw new Exception("Objeto Nao Encontrado");
		}
	}

	/* Buscar por Nome */
	public List<Estado> buscarPorNome(String nome) throws Exception {
		return repository.findByName(nome);
	}

	/* Buscar Todos */
	public List<Estado> buscarTodos() {
		return repository.findAll();
	}

	/* Delete */
	public void remove(Long id) throws Exception {
		Estado uf = new Estado();
		uf.setId(id);
		repository.delete(id);

	}

}
