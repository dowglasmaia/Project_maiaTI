package com.dowglasmaia.maiati.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dowglasmaia.maiati.domain.Cidade;
import com.dowglasmaia.maiati.domain.Estado;
import com.dowglasmaia.maiati.repository.domain.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repository;

	/* Salvar */
	public Cidade salvar(Cidade obj) {
		return repository.save(obj);
	}

	/* Buscar_por_ID */
	public Cidade buscarPorID(Long id) throws Exception {
		Cidade c = repository.findById(id);
		if (c != null) {
			return c;
		} else {
			throw new Exception();
		}
	}

	/* Buscar_por_Estado */
	public List<Cidade> buscarPorNome(Long estadoId) throws Exception {
		return repository.findByName(estadoId);
	}
	
	/* Buscar por Nome */
	public List<Cidade> buscarPorNome(String nome) throws Exception {
		return repository.findByName(nome);
	}
	

	/* Buscar_Todos */
	public List<Cidade> buscarTodos() {
		return repository.findAll();
	}

	/* Delete */
	public void remove(Long id) throws Exception {
		Cidade dep = new Cidade();
		dep.setId(id);
		repository.delete(id);

	}

}
