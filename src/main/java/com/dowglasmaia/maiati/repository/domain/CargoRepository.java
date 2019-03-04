package com.dowglasmaia.maiati.repository.domain;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dowglasmaia.maiati.domain.Cargo;
import com.dowglasmaia.maiati.repository.AbstractRepo;

@Repository
public class CargoRepository extends AbstractRepo<Cargo, Long>{
	
	/* buscar por nome, com createquery - dinamica */
	public List<Cargo> findByName(String nome) {
		return createDinamicQuery("select c from Cargo c where c.nome like concat('%',?1,'%')", nome);
	}

}
