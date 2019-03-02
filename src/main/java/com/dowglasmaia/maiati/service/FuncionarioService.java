package com.dowglasmaia.maiati.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dowglasmaia.maiati.domain.Funcionario;
import com.dowglasmaia.maiati.repository.domain.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository repository;

	/* Salvar */
	public Funcionario salvar(Funcionario obj) {
		return repository.save(obj);
	}

	/* Buscar por ID */
	public Funcionario buscarPorID(Long id) throws Exception {
		Funcionario dep = repository.findById(id);
		if (dep != null) {
			return dep;
		} else {
			throw new Exception();
		}
	}

	/* Buscar por Nome */
	public List<Funcionario> buscarPorNome(String nome) throws Exception {
		return repository.busrcarPorNome(nome);
	}

	/* Buscar Todos */
	public List<Funcionario> buscarTodos() {
		return repository.findAll();
	}

	/* Delete */
	public void remove(Long id) throws Exception {
		Funcionario dep = new Funcionario();
		dep.setId(id);
		repository.delete(id);

	}

}
