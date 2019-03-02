package com.dowglasmaia.maiati.repository.domain;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dowglasmaia.maiati.domain.Departamento;
import com.dowglasmaia.maiati.repository.AbstractRepo;

@Repository
public class DepartamentoRepository extends AbstractRepo<Departamento, Long>{

	/* buscar por nome, com createquery - dinamica */
	public List<Departamento> findByName(String nome) {
		return createDinamicQuery("select d from Departamento d where d.nome like concat('%',?1,'%')", nome);
	}


}
