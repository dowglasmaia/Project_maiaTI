package com.dowglasmaia.maiati.repository.domain;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dowglasmaia.maiati.domain.Endereco;
import com.dowglasmaia.maiati.repository.AbstractRepo;

@Repository
public class EnderecoRepository extends AbstractRepo<Endereco, Long>{
	
	/* buscar por nome, com createquery - dinamica */
	public List<Endereco> findByName(String nome) {
		return createDinamicQuery("select c from Cargo c where c.nome like concat('%',?1,'%')", nome);
	}

}
