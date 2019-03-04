package com.dowglasmaia.maiati.repository.domain;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dowglasmaia.maiati.domain.Estado;
import com.dowglasmaia.maiati.repository.AbstractRepo;

@Repository
public class EstadoRepository extends AbstractRepo<Estado, Long>{
	
	/* buscar por nome, com createquery - dinamica */
	public List<Estado> findByName(String nome) {
		return createDinamicQuery("select e from Estado e where e.nome like concat('%',?1,'%')", nome);
	}

}
