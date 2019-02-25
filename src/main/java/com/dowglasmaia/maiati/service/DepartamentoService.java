package com.dowglasmaia.maiati.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dowglasmaia.maiati.domain.Departamento;
import com.dowglasmaia.maiati.repository.domain.DepartamentoRepository;

@Service
public class DepartamentoService {

	@Autowired
	private DepartamentoRepository repository;

	/* Salvar */
	public Departamento salvar(Departamento obj) {
		return repository.save(obj);
	}

	/* Buscar por ID */
	public Departamento buscarPorID(Long id) throws Exception {
		Departamento dep = repository.findById(id);

		if (dep != null) {
			return dep;
		} else {
			throw new Exception();
		}

	}

	/* Buscar Todos */
	public List<Departamento> buscarTodos() {
		return repository.findAll();
	}

	/* Delete */
	public void remove(Long id) throws Exception{
		Departamento dep = new Departamento();
		dep.setId(id);
		repository.delete(id);

	}

}
