package com.dowglasmaia.maiati.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dowglasmaia.maiati.domain.Cargo;
import com.dowglasmaia.maiati.repository.domain.CargoRepository;

@Service
public class CargoService {

	@Autowired
	private CargoRepository repository;

	/* Salvar */
	public Cargo salvar(Cargo obj) {
		return repository.save(obj);
	}

	/* Buscar por ID */
	public Cargo buscarPorID(Long id) throws Exception {
		Cargo cg = repository.findById(id);
		if (cg != null) {
			return cg;
		} else {
			throw new Exception();
		}
	}

	/* Buscar por Nome */
	public List<Cargo> buscarPorNome(String nome) throws Exception {
		return repository.findByName(nome);
	}

	/* Buscar Todos */
	public List<Cargo> buscarTodos() {
		return repository.findAll();
	}

	/* Delete */
	public void remove(Long id) throws Exception {
		Cargo dep = new Cargo();
		dep.setId(id);
		repository.delete(id);

	}

}
