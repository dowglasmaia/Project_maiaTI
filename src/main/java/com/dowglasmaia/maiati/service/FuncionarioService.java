package com.dowglasmaia.maiati.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dowglasmaia.maiati.domain.Cargo;
import com.dowglasmaia.maiati.domain.Cidade;
import com.dowglasmaia.maiati.domain.Endereco;
import com.dowglasmaia.maiati.domain.Estado;
import com.dowglasmaia.maiati.domain.Funcionario;
import com.dowglasmaia.maiati.domain.func.dto.FuncionarioNewDTO;
import com.dowglasmaia.maiati.repository.domain.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository repository;

	/* Salvar */
	public Funcionario salvar(Funcionario obj) {
		return repository.save(obj);
	}

	/* Salvando o Funcionario e Suas Referencias */
	public Funcionario fromDTO(FuncionarioNewDTO objDTO) {

		Estado uf = objDTO.getEstado();

		Cargo cg = objDTO.getCargo();

		Cidade cid = new Cidade(null, objDTO.getCidade(), uf);

		Endereco end = new Endereco(null, objDTO.getLogradouro(), objDTO.getNumero(), objDTO.getBairro(),
				objDTO.getCep(), objDTO.getComplemento(), cid);

		Funcionario funcionario = new Funcionario(null, objDTO.getNome(), objDTO.getEmail(), objDTO.getTelefone(),
				objDTO.getDataAdmissao(), objDTO.getDataDemissao(), objDTO.getSalario(), cg, end);

		return funcionario;
	}

	/* Buscar por ID */
	public Funcionario buscarPorID(Long id) throws Exception {
		Funcionario fun = repository.findById(id);
		if (fun != null) {
			return fun;
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

	/* Update */
	public Funcionario update(Funcionario obj) throws Exception {
		Funcionario newObj = buscarPorID(obj.getId());
		updateData(newObj, obj);
		return repository.update(newObj);

	}

	/* mtdo aux. para update Funcionario */
	private void updateData(Funcionario newObj, Funcionario obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
		newObj.setSalario(obj.getSalario());
		newObj.setTelefone(obj.getTelefone());
		newObj.setDataDemissao(obj.getDataDemissao());
		newObj.setCargo(obj.getCargo());
		newObj.setEndereco(new Endereco(obj.getEndereco().getId(), obj.getEndereco().getLogradouro(), obj.getEndereco().getNumero(), obj.getEndereco().getBairro(), 
				obj.getEndereco().getCep(), obj.getEndereco().getComplemento(), obj.getEndereco().getCidade()));
		

	}

}
