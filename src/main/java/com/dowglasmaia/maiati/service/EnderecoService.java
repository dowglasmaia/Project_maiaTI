package com.dowglasmaia.maiati.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dowglasmaia.maiati.domain.Endereco;
import com.dowglasmaia.maiati.repository.domain.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repository;

	/* Salvar */
	public Endereco salvar(Endereco obj) {
		return repository.save(obj);
	}

	/* Buscar por ID */
	public Endereco buscarPorID(Long id) throws Exception {
		Endereco end = repository.findById(id);
		if (end != null) {
			return end;
		} else {
			throw new Exception();
		}
	}

	/* Buscar por Nome */
	public List<Endereco> buscarPorNome(String nome) throws Exception {
		return repository.findByName(nome);
	}

	/* Buscar Todos */
	public List<Endereco> buscarTodos() {
		return repository.findAll();
	}

	/* Delete */
	public void remove(Long id) throws Exception {
		Endereco end = new Endereco();
		end.setId(id);
		repository.delete(id);

	}

}
