package com.dowglasmaia.maiati.repository.domain;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.dowglasmaia.maiati.domain.Cidade;
import com.dowglasmaia.maiati.domain.Estado;
import com.dowglasmaia.maiati.repository.AbstractRepo;

@Repository
public class CidadeRepository extends AbstractRepo<Cidade, Long>{
	
	// Buscar Por Nome Usando JPQL
		public List<Cidade> findByName(Long estadoId) {
			TypedQuery<Cidade> query = getManager()
					.createQuery("select obj from Cidade obj where obj.estado.id = :estadoId", Cidade.class);
			query.setParameter("estadoId", estadoId );
			return query.getResultList();

		}

		
		
		/* buscar por nome, com createquery - dinamica */
		public List<Cidade> findByName(String nome) {
			return createDinamicQuery("select e from Cidade e where e.nome like concat('%',?1,'%')", nome);
		}


}
